package demo.ecorichhomework.domain.employee.repository;

import demo.ecorichhomework.domain.employee.data.dto.JobHistoryResponse;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface JobHistoryRepository {

    Long getJobHistoryCount(Integer employeeId);

    List<JobHistoryResponse> getJobHistoryList(Integer employeeId, Pageable pageable);

}
