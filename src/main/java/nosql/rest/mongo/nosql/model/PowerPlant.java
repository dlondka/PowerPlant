package nosql.rest.mongo.nosql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "powerPlant")
public class PowerPlant {

    @Id
    private ObjectId _id;
    private String country;
    private String country_long;
    private String name;
    private String gppd_idnr;
    private Double capacity_mw;
    private Double latitude;
    private Double longitude;
    private String primary_fuel;
    private String other_fuel1;
    private String other_fuel2;
    private String other_fuel3;
    private Integer commissioning_year;
    private String owner;
    private String source;
    private String url;
    private String geolocation_source;
    private Integer year_of_capacity_data;
}
