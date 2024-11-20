package demo.ecorichhomework.domain.employee.serivce.impl;

import demo.ecorichhomework.domain.department.data.Department;
import demo.ecorichhomework.domain.department.data.dto.DepartmentUpdateSalaryRequest;
import demo.ecorichhomework.domain.department.repository.DepartmentRepository;
import demo.ecorichhomework.domain.employee.data.Employee;
import demo.ecorichhomework.domain.employee.data.dto.EmployeeUpdateRequest;
import demo.ecorichhomework.domain.employee.repository.EmployeeRepository;
import demo.ecorichhomework.domain.employee.serivce.EmployeeService;
import demo.ecorichhomework.domain.job.data.Job;
import demo.ecorichhomework.domain.job.data.dto.SalaryLimitDto;
import demo.ecorichhomework.domain.job.repository.JobRepository;
import java.util.List;
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
        Job job = jobRepository.getById(request.jobId());
        departmentRepository.getById(request.departmentId());
        employeeRepository.getById(request.managerId(), "매니저를 찾을 수 없습니다.");

        Employee employee = employeeRepository.getById(employeeId);
        employee.update(request, job);
        return employee;
    }

    @Override
    public void updateSalaryOfDepartment(Integer departmentId, DepartmentUpdateSalaryRequest request) {
        departmentRepository.getById(departmentId);

        List<Employee> employees = employeeRepository.findAllEmployeesOfDepartment(departmentId);
        Double increasePoint = request.increasePoint();
        for (Employee employee : employees) {
            SalaryLimitDto salaryLimit = employee.getJob().getSalaryLimit();
            employee.updateSalaryByPercentage(increasePoint, salaryLimit);
        }

    }

}
