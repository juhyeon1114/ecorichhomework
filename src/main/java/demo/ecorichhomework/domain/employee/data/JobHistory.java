package demo.ecorichhomework.domain.employee.data;

import demo.ecorichhomework.domain.employee.data.embed.JobHistoryId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;

@Entity
@Getter
@Table(indexes = {
        @Index(name = "employee_id", columnList = "employeeId, startDate", unique = true)
})
public class JobHistory {

    @EmbeddedId
    private JobHistoryId jobHistoryId;
    private LocalDate endDate;
    private String jobId;
    private Integer departmentId;

    public Integer getEmployeeId() {
        return jobHistoryId.getEmployeeId();
    }

    public LocalDate getStartDate() {
        return jobHistoryId.getStartDate();
    }

}
