package demo.ecorichhomework.domain.employee.repository.impl;

import static demo.ecorichhomework.domain.employee.data.QEmployee.employee;
import static demo.ecorichhomework.domain.job.data.QJob.job;

import com.querydsl.jpa.impl.JPAQueryFactory;
import demo.ecorichhomework.domain.employee.data.Employee;
import demo.ecorichhomework.domain.employee.repository.EmployeeRepository;
import demo.ecorichhomework.domain.employee.repository.jpa.EmployeeJpaRepository;
import demo.ecorichhomework.domain.job.data.QJob;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EmployeeJpaRepository employeeJpaRepository;
    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Employee> findById(Integer employeeId) {
        return employeeJpaRepository.findById(employeeId);
    }

    @Override
    public List<Employee> findAllEmployeesOfDepartment(Integer departmentId) {
        return queryFactory.selectFrom(employee)
                .leftJoin(employee.job, job).fetchJoin()
                .where(employee.departmentId.eq(departmentId))
                .fetch();
    }

}
