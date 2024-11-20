package demo.ecorichhomework.domain.employee.repository;

import demo.ecorichhomework.domain.employee.data.dto.EmployeeDetailResponse;
import demo.ecorichhomework.global.exception.exceptions.ItemNotFoundException;
import java.util.Optional;

public interface EmployeeDetailRepository {

    Optional<EmployeeDetailResponse> findEmployeeDetailResponse(Integer employeeId);

    default EmployeeDetailResponse getEmployeeDetailResponse(Integer employeeId) {
        return findEmployeeDetailResponse(employeeId).orElseThrow(
                () -> new ItemNotFoundException("직원 정보를 찾을 수 없습니다")
        );
    }
    
}
