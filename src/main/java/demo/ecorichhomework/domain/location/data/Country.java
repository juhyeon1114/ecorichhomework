package demo.ecorichhomework.domain.location.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "countries")
public class Country {

    @Id
    @Column(columnDefinition = "CHAR(2)")
    private String countryId;
    private String countryName;
    private Integer regionId;

}
