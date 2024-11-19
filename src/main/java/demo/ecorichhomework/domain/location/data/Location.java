package demo.ecorichhomework.domain.location.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "locations")
public class Location {

    @Id
    private Integer locationId;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    @Column(columnDefinition = "CHAR(2)")
    private String countryId;

}
