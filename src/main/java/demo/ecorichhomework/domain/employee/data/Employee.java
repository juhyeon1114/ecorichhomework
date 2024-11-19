package demo.ecorichhomework.domain.employee.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;

@Entity
@Getter
@Table(name = "employees")
public class Employee {

    @Id
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate hireDate;
    private String jobId;
    private BigDecimal salary;
    private BigDecimal commissionPct;
    private Integer managerId; // todo
    private Integer departmentId; // todo

}
