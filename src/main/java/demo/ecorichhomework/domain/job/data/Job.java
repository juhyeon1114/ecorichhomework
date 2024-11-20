package demo.ecorichhomework.domain.job.data;

import demo.ecorichhomework.domain.job.data.dto.SalaryLimitDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
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

    public SalaryLimitDto getSalaryLimit() {
        return new SalaryLimitDto(minSalary, maxSalary);
    }

}
