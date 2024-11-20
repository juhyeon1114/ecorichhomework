package demo.ecorichhomework.domain.department.repository.jpa;

import demo.ecorichhomework.domain.department.data.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentJpaRepository extends JpaRepository<Department, Integer> {

}
