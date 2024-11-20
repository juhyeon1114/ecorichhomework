package demo.ecorichhomework.domain.job.repository;

import demo.ecorichhomework.domain.job.data.Job;
import demo.ecorichhomework.global.exception.exceptions.ItemNotFoundException;
import java.util.Optional;

public interface JobRepository {

    Optional<Job> findById(String jobId);

    default Job getById(String jobId) {
        return findById(jobId)
                .orElseThrow(() -> new ItemNotFoundException("직무를 찾을 수 없습니다."));
    }

}
