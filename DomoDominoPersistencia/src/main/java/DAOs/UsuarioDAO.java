/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mycompany.domodominopersistencia.Usuario;
import conexion.Conexion;
import org.bson.conversions.Bson;


public class UsuarioDAO {
    private final MongoDatabase database;

    public UsuarioDAO() {
        this.database = Conexion.getDatabase();
    }

    /**
     * Metodo que retorna la coleccion de usuarios
     * @return 
     */
    private MongoCollection<Usuario> getCollection() {
        return database.getCollection("Usuarios", Usuario.class);
    }

    /**
     * Registrar un nuevo usuario
     * @param usuario 
     */
    public void registrar(Usuario usuario) {
        MongoCollection<Usuario> collection = getCollection();
        collection.insertOne(usuario);
    }
    
    /**
     * Método para iniciar sesión
     * @param correo
     * @param contra
     * @return devielve Usuario si las credenciales son validas
     */
    public boolean iniciarSesion(String correo, String contra) {
        Usuario usuario = buscarPorCorreo(correo);
        System.out.println("Usuario encontrado: " + usuario); 
        return usuario != null && usuario.getContraseña().equals(contra);
    }

    /**
     * Metodo que busca usuario por el correo
     * @param correo
     * @return usuario
     */
    public Usuario buscarPorCorreo(String correo) {
        MongoCollection<Usuario> collection = getCollection();
        Bson filter = Filters.eq("correo", correo);
        System.out.println(collection.find(filter).first());
        return collection.find(filter).first(); 
    }
    
    /**
     * Metodo que busca usuario
     * @param nombre
     * @return 
     */
    public Usuario buscarPorNombre(String nombre) {
        MongoCollection<Usuario> collection = getCollection();
        Bson filter = Filters.eq("nombre", nombre);
        return collection.find(filter).first(); 
    }

    /**
     * Metodo que eliminar un usuario
     * @param id 
     */
    public void eliminar(Long id) {
        MongoCollection<Usuario> collection = getCollection();
        Bson filter = Filters.eq("id", id);
        collection.deleteOne(filter);  
    }
}
