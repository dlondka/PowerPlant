package nosql.rest.mongo.nosql.repository;

import nosql.rest.mongo.nosql.model.PowerPlant;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "powerPlant")
public interface PowerPlantRepository extends MongoRepository<PowerPlant, ObjectId> {

}
