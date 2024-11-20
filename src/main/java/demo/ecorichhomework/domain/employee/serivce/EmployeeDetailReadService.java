package demo.ecorichhomework.domain.employee.serivce;

import demo.ecorichhomework.domain.employee.data.dto.EmployeeDetailResponse;

public interface EmployeeDetailReadService {

    EmployeeDetailResponse getEmployeeDetailResponse(Integer employeeId);

}
