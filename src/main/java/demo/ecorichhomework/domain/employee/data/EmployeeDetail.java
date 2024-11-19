package demo.ecorichhomework.domain.employee.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import org.springframework.data.annotation.Immutable;

@Entity
@Getter
@Immutable
@Table(name = "emp_details_view")
public class EmployeeDetail {

    @Id
    private Integer employeeId;
    private String jobId;
    private Integer managerId;
    private Integer departmentId;
    private Integer locationId;
    @Column(columnDefinition = "CHAR(2)")
    private String countryId;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private BigDecimal commissionPct;
    private String departmentName;
    private String jobTitle;
    private String city;
    private String stateProvince;
    private String countryName;
    private String regionName;

}
