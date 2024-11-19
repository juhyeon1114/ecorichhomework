package demo.ecorichhomework.domain.location.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "regions")
public class Region {

    @Id
    private Integer regionId;
    private String regionName;

}
