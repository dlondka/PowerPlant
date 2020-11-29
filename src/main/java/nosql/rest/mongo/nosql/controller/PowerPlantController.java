package nosql.rest.mongo.nosql.controller;

import nosql.rest.mongo.nosql.model.PowerPlant;
import nosql.rest.mongo.nosql.repository.PowerPlantRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class PowerPlantController {

    @Autowired
    private PowerPlantRepository powerPlantRepository;

    // POST for power plant
    @PostMapping("/addPowerPlant")
    public ResponseEntity<PowerPlant> addPowerPlant(@RequestBody PowerPlant powerPlant) {
        try {
            PowerPlant pp = powerPlantRepository.save(powerPlant);
            return new ResponseEntity<>(pp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE for power plant by id
    @DeleteMapping("/deletePowerPlant/{id}")
    public ResponseEntity<PowerPlant> deletePowerPlant(@PathVariable("id") ObjectId id) {
        try {
            powerPlantRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET for all power plants
    @GetMapping("/getAllPowerPlants")
    public ResponseEntity<List<PowerPlant>> getPowerPlants() {
        try {
            List<PowerPlant> powerPlants = powerPlantRepository.findAll();
            return new ResponseEntity<>(powerPlants, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // GET for power plant by id
    @GetMapping("/getPowerPlant/{id}")
    public ResponseEntity<PowerPlant> getPowerPlant(@PathVariable("id") ObjectId id) {
        Optional<PowerPlant> powerPlant = powerPlantRepository.findById(id);
        if (powerPlant.isPresent()) {
            return new ResponseEntity<>(powerPlant.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // PUT for
    @PutMapping("/updatePowerPlant/{id}")
    public ResponseEntity<PowerPlant> updatePowerPlant(@RequestBody PowerPlant newPowerPlant,
                                                       @PathVariable("id") ObjectId id) {
        Optional<PowerPlant> pp = powerPlantRepository.findById(id);
        if (pp.isPresent()) {
            PowerPlant powerPlant = pp.get();
            powerPlant.setCountry(newPowerPlant.getCountry());
            powerPlant.setCountry_long(newPowerPlant.getCountry_long());
            powerPlant.setName(newPowerPlant.getName());
            powerPlant.setGppd_idnr(newPowerPlant.getGppd_idnr());
            powerPlant.setCapacity_mw(newPowerPlant.getCapacity_mw());
            powerPlant.setLatitude(newPowerPlant.getLatitude());
            powerPlant.setLongitude(newPowerPlant.getLongitude());
            powerPlant.setPrimary_fuel(newPowerPlant.getPrimary_fuel());
            powerPlant.setOther_fuel1(newPowerPlant.getOther_fuel1());
            powerPlant.setOther_fuel2(newPowerPlant.getOther_fuel2());
            powerPlant.setOther_fuel3(newPowerPlant.getOther_fuel3());
            powerPlant.setCommissioning_year(newPowerPlant.getCommissioning_year());
            powerPlant.setOwner(newPowerPlant.getOwner());
            powerPlant.setSource(newPowerPlant.getSource());
            powerPlant.setUrl(newPowerPlant.getUrl());
            powerPlant.setGeolocation_source(newPowerPlant.getGeolocation_source());
            powerPlant.setYear_of_capacity_data(newPowerPlant.getYear_of_capacity_data());

            return new ResponseEntity<>(powerPlantRepository.save(powerPlant), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
