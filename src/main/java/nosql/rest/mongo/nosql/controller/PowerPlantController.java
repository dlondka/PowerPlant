package nosql.rest.mongo.nosql.controller;

import nosql.rest.mongo.nosql.model.PowerPlant;
import nosql.rest.mongo.nosql.repository.PowerPlantRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PowerPlantController {

    @Autowired
    private PowerPlantRepository powerPlantRepository;

    @PostMapping("/addPowerPlant")
    public String savePowerPlant(@RequestBody PowerPlant powerPlant) {
        powerPlantRepository.save(powerPlant);

        return "Added power plant with id: " + powerPlant.get_id();
    }

    @DeleteMapping("/deletePowerPlant/{id}")
    public String deletePowerPlant(@PathVariable ObjectId id) {
        powerPlantRepository.deleteById(id);
        return "Deleted power plant with id: " + id;
    }

    @GetMapping("/findAllPowerPlants")
    public List<PowerPlant> getPowerPlants() {
        return powerPlantRepository.findAll();
    }
}
