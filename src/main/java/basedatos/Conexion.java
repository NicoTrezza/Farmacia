package basedatos;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Conexion {

	protected MongoClient mongoClient;
	protected MongoDatabase db;
	
	public Conexion() {
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		this.mongoClient = new MongoClient();
		this.db = mongoClient.getDatabase("farmacia");
		this.db = this.db.withCodecRegistry(pojoCodecRegistry);
	}
		
}
