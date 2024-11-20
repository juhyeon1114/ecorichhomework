package demo.ecorichhomework.domain.employee.serivce.impl;

import demo.ecorichhomework.domain.employee.data.dto.JobHistoryResponse;
import demo.ecorichhomework.domain.employee.repository.JobHistoryRepository;
import demo.ecorichhomework.domain.employee.serivce.JobHistoryReadService;
import demo.ecorichhomework.global.dto.PaginationRequestParam;
import demo.ecorichhomework.global.utils.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobHistoryReadServiceImpl implements JobHistoryReadService {

    private final JobHistoryRepository jobHistoryRepository;

    @Override
    public PagedModel<JobHistoryResponse> getJobHistoryPage(Integer employeeId, PaginationRequestParam param) {
        Pageable pageable = param.pageable();
        return PageUtils.pagination(
                jobHistoryRepository.getJobHistoryList(employeeId, pageable),
                jobHistoryRepository.getJobHistoryCount(employeeId),
                pageable
        );
    }
}
