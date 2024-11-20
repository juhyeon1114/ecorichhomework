package demo.ecorichhomework.domain.employee.repository;

import demo.ecorichhomework.domain.employee.data.Employee;
import demo.ecorichhomework.global.exception.exceptions.ItemNotFoundException;
import java.util.Optional;

public interface EmployeeRepository {

    Optional<Employee> findById(Integer employeeId);

    default Employee getById(Integer employeeId) {
        return getById(employeeId, "직원을 찾을 수 없습니다.");
    }

    default Employee getById(Integer employeeId, String message) {
        return findById(employeeId).orElseThrow(
                () -> new ItemNotFoundException(message)
        );
    }

}
