package zipcoder.models;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
/**
 * Created by ghumphrey on 10/26/15.
 */
@Entity
@Table(name = "camera")
public class RedLight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    @NotNull
    @JsonProperty("site_location")
    private String site_location;

    @NotNull
    @JsonProperty("intersection")
    private String intersection;

    @NotNull
    @JsonProperty("number_of_approaches")
    private String number_of_approaches;

    @NotNull
    @JsonProperty("citations")
    private String citations;

    @NotNull
    @JsonProperty("warnings")
    private String warnings;

    @NotNull
    @JsonProperty("sensor_type")
    private String sensor_type;

    @NotNull
    @JsonProperty("site_id")
    private String site_id;

    public RedLight(){}

    public RedLight(String site_location, String intersection, String number_of_approaches, String citations, String warnings, String sensor_type, String site_id) {

        this.site_location = site_location;
        this.intersection = intersection;
        this.number_of_approaches = number_of_approaches;
        this.citations = citations;
        this.warnings = warnings;
        this.sensor_type = sensor_type;
        this.site_id = site_id;
    }

    public Integer ID() {
        return ID;
    }

    public void ID(Integer cameraID) {
        this.ID = cameraID;
    }

    public String getSite_location() {
        return site_location;
    }

    public void setSite_location(String site_location) {
        this.site_location = site_location;
    }

    public String getIntersection() {
        return intersection;
    }

    public void setIntersection(String intersection) {
        this.intersection = intersection;
    }

    public String getNumber_of_approaches() {
        return number_of_approaches;
    }

    public void setNumber_of_approaches(String number_of_approaches) {
        this.number_of_approaches = number_of_approaches;
    }

    public String getCitations() {
        return citations;
    }

    public void setCitations(String citations) {
        this.citations = citations;
    }

    public String getWarnings() {
        return warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    public String getSensor_type() {
        return sensor_type;
    }

    public void setSensor_type(String sensor_type) {
        this.sensor_type = sensor_type;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }
    public String toString(){
        return site_id +" "+ intersection;
    }
}
