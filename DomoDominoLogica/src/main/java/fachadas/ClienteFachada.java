package fachadas;

import cliente.Cliente;

public class ClienteFachada implements IClienteFachada{
    private Cliente cliente;

    public ClienteFachada(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void enviarMensaje(String mensaje) {
        cliente.enviarMensaje(mensaje);
    }

    // Otros métodos que queramos exponer de Cliente
}