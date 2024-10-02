package dtos;

public class UsuarioDto {
    
    private String correo, contraseña, nombre;

    public UsuarioDto() {
    }

    public UsuarioDto(String correo, String contraseña, String nombre) {
        this.correo = correo;
        this.contraseña = contraseña;
        this.nombre = nombre;
    }

    public UsuarioDto(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
