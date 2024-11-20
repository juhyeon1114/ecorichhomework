package demo.ecorichhomework.domain.employee.repository.jpa;

import demo.ecorichhomework.domain.employee.data.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {

}
