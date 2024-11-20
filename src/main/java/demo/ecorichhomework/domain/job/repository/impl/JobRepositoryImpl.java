package demo.ecorichhomework.domain.job.repository.impl;

import demo.ecorichhomework.domain.job.data.Job;
import demo.ecorichhomework.domain.job.repository.JobRepository;
import demo.ecorichhomework.domain.job.repository.jpa.JobJpaRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JobRepositoryImpl implements JobRepository {

    private final JobJpaRepository jobJpaRepository;

    @Override
    public Optional<Job> findById(String jobId) {
        return jobJpaRepository.findById(jobId);
    }

}
