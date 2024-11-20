package demo.ecorichhomework.domain.employee.serivce;

import demo.ecorichhomework.domain.employee.data.dto.JobHistoryResponse;
import org.springframework.data.web.PagedModel;

public interface JobHistoryReadService {

    PagedModel<JobHistoryResponse> getJobHistoryPage(Integer employeeId, Integer page, Integer size);

}
