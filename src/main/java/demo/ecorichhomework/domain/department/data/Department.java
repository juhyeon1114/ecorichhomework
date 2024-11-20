package demo.ecorichhomework.domain.department.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "departments")
public class Department {

    @Id
    private Integer departmentId;
    private String departmentName;
    private Integer managerId;
    private Integer locationId;

}
