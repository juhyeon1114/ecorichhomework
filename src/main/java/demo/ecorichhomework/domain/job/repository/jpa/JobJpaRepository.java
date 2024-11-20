package demo.ecorichhomework.domain.job.repository.jpa;

import demo.ecorichhomework.domain.job.data.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobJpaRepository extends JpaRepository<Job, String> {

}
