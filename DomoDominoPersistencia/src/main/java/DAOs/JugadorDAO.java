/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mycompany.domodominopersistencia.Jugador;
import conexion.Conexion;
import org.bson.conversions.Bson;
import java.util.List;

/**
 *
 * @author favel
 */
public class JugadorDAO {
    private final MongoDatabase database;

    public JugadorDAO() {
        this.database = Conexion.getDatabase();
    }

    // Colección de jugadores
    private MongoCollection<Jugador> getCollection() {
        return database.getCollection("jugadores", Jugador.class);
    }

    // Registrar un nuevo jugador
    public void registrar(Jugador jugador) {
        MongoCollection<Jugador> collection = getCollection();
        collection.insertOne(jugador);
    }

    // Buscar un jugador por su nombre
    public Jugador buscarPorNombre(String nombre) {
        MongoCollection<Jugador> collection = getCollection();
        Bson filter = Filters.eq("nombre", nombre);
        return collection.find(filter).first();  // Retorna el primer jugador encontrado
    }

    // Eliminar un jugador
    public void eliminar(Long id) {
        MongoCollection<Jugador> collection = getCollection();
        Bson filter = Filters.eq("id", id);
        collection.deleteOne(filter);  // Elimina el jugador por ID
    }
}
