package demo.ecorichhomework.domain.employee.repository.impl;

import demo.ecorichhomework.domain.employee.data.Employee;
import demo.ecorichhomework.domain.employee.repository.EmployeeRepository;
import demo.ecorichhomework.domain.employee.repository.jpa.EmployeeJpaRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EmployeeJpaRepository employeeJpaRepository;

    @Override
    public Optional<Employee> findById(Integer employeeId) {
        return employeeJpaRepository.findById(employeeId);
    }

}
