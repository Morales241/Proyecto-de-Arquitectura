package conexion;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class Conexion {
    private static MongoClient mongoClient = null;
    //Si se conectaron por Atlas su URL es la que les proporciona la página
    private static final String URI = "mongodb+srv://jesusmorales245335:c2wmVkjwdPvKOx8u@basededatosavanzadas.xri66fk.mongodb.net/?retryWrites=true&w=majority&appName=BaseDeDatosAvanzadas";
                                       
    private static final String DATABASE_NAME = "DomoDomino";

    private  Conexion() {
    }
    
    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {

            // 1. Configuramos el codec para manejar POJOs
            CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(  
                    MongoClientSettings.getDefaultCodecRegistry(),
                    CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
            );                                                                                 
                               
            //2.Configuramos los ajustes del cliente MongoDB, incluyendo la cadena de conexión (URL) y el registro de codecs anterior
            MongoClientSettings clientSettings = MongoClientSettings.builder()
                    .applyConnectionString(new com.mongodb.ConnectionString(URI))
                    .codecRegistry(pojoCodecRegistry)
                    .build();

            //3. Asignamos los ajustes al MongoCliente static de la clase
            mongoClient = MongoClients.create(clientSettings);
            //4. Regresamos la base de datos con la configuración codecs
            return mongoClient.getDatabase(DATABASE_NAME).withCodecRegistry(pojoCodecRegistry);

        }
        
        // si no es null, la regresamos nuevamente
        return mongoClient.getDatabase(DATABASE_NAME);
    }
}
