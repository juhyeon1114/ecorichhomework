package demo.ecorichhomework.domain.employee.data;

import demo.ecorichhomework.domain.employee.data.dto.EmployeeUpdateRequest;
import demo.ecorichhomework.domain.job.data.Job;
import demo.ecorichhomework.domain.job.data.dto.SalaryLimitDto;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private BigDecimal salary;
    private BigDecimal commissionPct;
    private Integer managerId;
    private Integer departmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Job job;

    // === update 메서드 ===
    public void update(EmployeeUpdateRequest request, Job job) {
        this.firstName = request.firstName();
        this.lastName = request.lastName();
        this.email = request.email();
        this.phoneNumber = request.phoneNumber();
        this.hireDate = request.hireDate();
        this.commissionPct = request.commissionPct();
        this.departmentId = request.departmentId();
        updateJob(job);
        updateSalary(request.salary(), job.getSalaryLimit());
        updateManager(request.managerId());
    }

    public void updateSalary(BigDecimal salary, SalaryLimitDto limitDto) {
        limitDto.validateProperSalary(salary);
        this.salary = salary;
    }

    public void updateSalaryByPercentage(Double percentage, SalaryLimitDto limitDto) {
        if (percentage < 0 || percentage > 1) {
            throw new IllegalArgumentException("급여 인상률 값이 옳바르지 않습니다.");
        }
        BigDecimal newSalary = this.salary.multiply(BigDecimal.valueOf(1 + percentage));
        updateSalary(newSalary, limitDto);
    }

    public void updateManager(Integer managerId) {
        if (managerId.equals(employeeId)) {
            throw new IllegalArgumentException("자기 자신을 매니저로 지정할 수 없습니다.");
        }
        this.managerId = managerId;
    }

    public void updateJob(Job job) {
        this.job = job;
    }

}
