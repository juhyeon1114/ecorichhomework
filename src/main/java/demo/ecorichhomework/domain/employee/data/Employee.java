package demo.ecorichhomework.domain.employee.data;

import demo.ecorichhomework.domain.employee.data.dto.EmployeeUpdateRequest;
import demo.ecorichhomework.domain.job.data.dto.SalaryLimitDto;
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
    private Integer managerId;
    private Integer departmentId;

    public void update(EmployeeUpdateRequest request, SalaryLimitDto limitDto) {
        this.firstName = request.firstName();
        this.lastName = request.lastName();
        this.email = request.email();
        this.phoneNumber = request.phoneNumber();
        this.hireDate = request.hireDate();
        this.commissionPct = request.commissionPct();
        this.departmentId = request.departmentId();
        updateSalary(request.salary(), limitDto);
        updateManager(request.managerId());
    }

    public void updateSalary(BigDecimal salary, SalaryLimitDto limitDto) {
        limitDto.validateProperSalary(salary);
        this.salary = salary;
    }

    public void updateManager(Integer managerId) {
        if (managerId.equals(employeeId)) {
            throw new IllegalArgumentException("자기 자신을 매니저로 지정할 수 없습니다.");
        }
        this.managerId = managerId;
    }

}
