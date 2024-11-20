package demo.ecorichhomework.domain.employee.repository;

import static demo.ecorichhomework.domain.department.data.QDepartment.department;
import static demo.ecorichhomework.domain.employee.data.QJobHistory.jobHistory;
import static demo.ecorichhomework.domain.job.data.QJob.job;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import demo.ecorichhomework.domain.employee.data.dto.JobHistoryResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JobHistoryRepositoryImpl implements JobHistoryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Long getJobHistoryCount(Integer employeeId) {
        return queryFactory
                .select(Wildcard.count)
                .from(jobHistory)
                .where(jobHistory.jobHistoryId.employeeId.eq(employeeId))
                .fetchFirst();
    }

    @Override
    public List<JobHistoryResponse> getJobHistoryList(Integer employeeId, Pageable pageable) {
        return queryFactory.select(Projections.constructor(JobHistoryResponse.class,
                        jobHistory.jobHistoryId.employeeId,
                        jobHistory.jobHistoryId.startDate,
                        jobHistory.endDate,
                        job.jobTitle,
                        department.departmentName
                ))
                .from(jobHistory)
                .leftJoin(department).on(jobHistory.departmentId.eq(department.departmentId))
                .leftJoin(job).on(jobHistory.jobId.eq(job.jobId))
                .where(
                        jobHistory.jobHistoryId.employeeId.eq(employeeId)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(jobHistory.jobHistoryId.startDate.desc())
                .fetch();
    }
}
