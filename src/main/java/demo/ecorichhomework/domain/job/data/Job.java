package demo.ecorichhomework.domain.job.data;

import demo.ecorichhomework.domain.employee.data.Employee;
import demo.ecorichhomework.domain.job.data.dto.SalaryLimitDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;

@Entity
@Getter
@Table(name = "jobs")
public class Job {

    @Id
    private String jobId;
    private String jobTitle;
    private BigDecimal minSalary;
    private BigDecimal maxSalary;

    @OneToMany(mappedBy = "job")
    private List<Employee> employees;

    public SalaryLimitDto getSalaryLimit() {
        return new SalaryLimitDto(minSalary, maxSalary);
    }

}
