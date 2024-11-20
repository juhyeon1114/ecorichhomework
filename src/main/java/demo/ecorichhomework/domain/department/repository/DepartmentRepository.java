package demo.ecorichhomework.domain.department.repository;

import demo.ecorichhomework.domain.department.data.Department;
import demo.ecorichhomework.global.exception.exceptions.ItemNotFoundException;
import java.util.Optional;

public interface DepartmentRepository {

    Optional<Department> findById(Integer departmentId);

    default Department getById(Integer departmentId) {
        return findById(departmentId)
                .orElseThrow(() -> new ItemNotFoundException("부서를 찾을 수 없습니다."));
    }

}
