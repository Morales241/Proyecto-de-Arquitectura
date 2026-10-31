# DomoDomino — Dominó multijugador en Java (P2P centralizado)

Juego de dominó en red: cada dispositivo es cliente y servidor a la vez. Un servidor central empareja, reparte el estado y avisa a todos cuando alguien juega; cada cliente valida y pinta su tablero. Patrones: Fachada, Mediador, Observer con eventos tipados, DTO y Singleton donde toca.

## Módulos

| Módulo | Qué contiene |
| --- | --- |
| `DomoDominoDominio` | Reglas puras: `Ficha`, `Arreglo`, `Pozo`, `GestorTurnos`. Sin red, sin UI. |
| `DomoDominoLogica` | Casos de uso (`Logica*`, `ArregloFachada`). No conoce la vista: compila sin Mvc. |
| `DomoDominoMvc` | Pantallas Swing, `LogicaPrincipal` (raíz de composición) y `DomoDominoMain`. |
| `DomoDominoUtileria` | DTOs y eventos que viajan por la red (`eventos/`, `dtos/`). |
| `DomoDominoCliente` / `ServerInterno` | Red del jugador (sockets + Gson). |
| `DomoDominoServerCentral*` | Servidor de partidas: empareja, reparte y notifica a todos. |

```mermaid
flowchart LR
    subgraph vista["Mvc (vista + arranque)"]
        UI["Pantallas Swing"]
        ROOT["LogicaPrincipal\nraiz de composicion"]
    end
    subgraph nucleo["Logica + Dominio"]
        LOG["Casos de uso"]
        DOM["Reglas (Ficha, Arreglo)"]
    end
    subgraph red["Red"]
        CLI["Cliente"]
        SRV["Servidor central"]
    end
    UI -->|"llama"| LOG
    LOG -->|"usa"| DOM
    LOG -->|"manda/recibe"| CLI
    CLI -->|"sockets + Gson"| SRV
    SRV ==>|"notifica a todos"| CLI
```

```mermaid
flowchart TB
    subgraph pc1["PC 1: servidor"]
        A["ArrancarServidorCentral\npuerto 8190"]
    end
    subgraph pc2["PC 2 y 3: jugadores"]
        B["DomoDominoMain\n2 clientes"]
    end
    B -->|"conectar (IP del servidor)"| A
```

## Cómo correrlo

Requisitos: JDK 21, Maven, los 2+ equipos en la misma red.

```bash
# 1. Servidor central (puerto 8190, imprime su IP al arrancar)
mvn -pl DomoDominoServerCentralServidor -am install -DskipTests
# correr ArrancarServidorCentral

# 2. Cada jugador abre el juego (apunta a la IP del servidor)
# DomoDominoMain en DomoDominoMvc
```

Ojo: la IP del servidor está fija en el código (`LogicaCrearPartida`, `192.168.100.11:8190`). Cámbiala a la IP que imprime el servidor. Mongo (`DomoDominoDominio/conexion`) está preparado pero el flujo actual no lo usa.

## Protocolo (eventos)

Todo lo que cruza la red es un DTO en `eventos/` + callbacks con nombre de intención (`IEventoPonerFicha`, `IEventoRegresar`, `IEventoTableroCambio`...). Nada de `actualizar()` ciego.

```mermaid
sequenceDiagram
    participant V as Vista
    participant L as LogicaPrincipal
    participant C as Comunicaciones
    participant S as Servidor central
    V->>L: crearPartida(jugador)
    L->>C: conectar + enviar jugador
    C->>S: unirse / crear
    S-->>C: notificarObservadoreCrearPartida
    C-->>L: respuesta crear partida
    L-->>V: mostrar tablero
```

```mermaid
sequenceDiagram
    participant V as Vista (tablero)
    participant M as TableroModel
    participant A as ArregloFachada
    participant S as Servidor central
    V->>M: colocarFicha(ficha, extremo, direccion)
    M->>A: ponerFicha(evento)
    A->>A: valida + coloca en Ficha[][]
    A-->>V: tableroCambio (repinta)
    A->>S: difunde jugada
    S-->>V: actualizan los demas
```

## Regla del tablero

Matriz de `Ficha` (no números): `null` = vacío. Cada ficha ocupa 2 celdas (1 si es mula). Solo abre una mula al centro; los extremos mandan qué encaja. Ver `ArregloFachada` y `ArregloTest`.

## Estado

En reestructura (`reestructuracion`): tablero con entidades, Lógica sin dependencia a Vista, eventos con nombre, 8 tests verdes. Pendiente: exportar diagramas draw.io y gif de 2 clientes.
