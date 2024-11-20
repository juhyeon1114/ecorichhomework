package demo.ecorichhomework.domain.employee.serivce.impl;

import demo.ecorichhomework.domain.department.repository.DepartmentRepository;
import demo.ecorichhomework.domain.employee.data.Employee;
import demo.ecorichhomework.domain.employee.data.dto.EmployeeUpdateRequest;
import demo.ecorichhomework.domain.employee.repository.EmployeeRepository;
import demo.ecorichhomework.domain.employee.serivce.EmployeeService;
import demo.ecorichhomework.domain.job.data.dto.SalaryLimitDto;
import demo.ecorichhomework.domain.job.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final JobRepository jobRepository;

    @Override
    public Employee updateEmployee(Integer employeeId, EmployeeUpdateRequest request) {
        SalaryLimitDto salaryLimitDto = jobRepository.getById(request.jobId()).getSalaryLimit();
        departmentRepository.getById(request.departmentId());
        employeeRepository.getById(request.managerId(), "매니저를 찾을 수 없습니다.");

        Employee employee = employeeRepository.getById(employeeId);
        employee.update(request, salaryLimitDto);
        return employee;
    }

}
