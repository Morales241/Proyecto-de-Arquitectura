package observers;

import dtos.UsuarioDto;

public interface IObservableUsuarioDto {
    public void agregarObservador(IObserverUsuarioDto observador);
    
    public void eliminarObservador(IObserverUsuarioDto observador);
    
    public void notificarObservadores(UsuarioDto usuarioDto);
}
