package demo.ecorichhomework.domain.department.repository.impl;

import demo.ecorichhomework.domain.department.data.Department;
import demo.ecorichhomework.domain.department.repository.DepartmentRepository;
import demo.ecorichhomework.domain.department.repository.jpa.DepartmentJpaRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DepartmentRepositoryImpl implements DepartmentRepository {

    private final DepartmentJpaRepository departmentJpaRepository;

    @Override
    public Optional<Department> findById(Integer departmentId) {
        return departmentJpaRepository.findById(departmentId);
    }

}
