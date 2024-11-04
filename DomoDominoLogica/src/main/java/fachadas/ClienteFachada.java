package fachadas;

import cliente.Cliente;

public class ClienteFachada implements IClienteFachada{
    private Cliente cliente;

    public ClienteFachada(Cliente cliente) {
        this.cliente = cliente;
    }

    public void enviarMensaje(String mensaje) {
        cliente.enviarMensaje(mensaje);
    }

    // Otros métodos que quieramos exponer de Cliente
}
