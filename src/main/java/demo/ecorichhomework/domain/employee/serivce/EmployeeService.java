package demo.ecorichhomework.domain.employee.serivce;

import demo.ecorichhomework.domain.employee.data.Employee;
import demo.ecorichhomework.domain.employee.data.dto.EmployeeUpdateRequest;

public interface EmployeeService {

    Employee updateEmployee(Integer employeeId, EmployeeUpdateRequest request);

}
