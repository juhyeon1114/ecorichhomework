package demo.ecorichhomework.domain.employee.controller;

import demo.ecorichhomework.domain.department.data.dto.DepartmentUpdateSalaryRequest;
import demo.ecorichhomework.domain.employee.data.dto.EmployeeDetailResponse;
import demo.ecorichhomework.domain.employee.data.dto.EmployeeUpdateRequest;
import demo.ecorichhomework.domain.employee.data.dto.JobHistoryResponse;
import demo.ecorichhomework.domain.employee.serivce.EmployeeDetailReadService;
import demo.ecorichhomework.domain.employee.serivce.EmployeeService;
import demo.ecorichhomework.domain.employee.serivce.JobHistoryReadService;
import demo.ecorichhomework.global.dto.PaginationRequestParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "직원(Employee) API", description = "직원을 조회하하고, 직원의 정보를 수정할 수 있습니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeDetailReadService employeeDetailReadService;
    private final EmployeeService employeeService;
    private final JobHistoryReadService jobHistoryReadService;

    @Operation(summary = "직원 상세 정보 조회 API")
    @GetMapping("/{employeeId}")
    public EmployeeDetailResponse getEmployee(
            @Parameter(description = "직원 id") @PathVariable("employeeId") Integer employeeId
    ) {
        return employeeDetailReadService.getEmployeeDetailResponse(employeeId);
    }

    @Operation(summary = "직원 근무 이력 조회 API")
    @GetMapping("/{employeeId}/history")
    public PagedModel<JobHistoryResponse> getEmployeeHistory(
            @Parameter(description = "직원 id") @PathVariable("employeeId") Integer employeeId,
            @Parameter(description = "페이지") @RequestParam(value = "page", defaultValue = "0") Integer page,
            @Parameter(description = "한 페이지당 크기") @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        return jobHistoryReadService.getJobHistoryPage(employeeId, new PaginationRequestParam(page, size));
    }

    @Operation(summary = "직원 정보 업데이트 API")
    @PutMapping("/{employeeId}")
    public Integer updateEmployee(
            @Parameter(description = "직원 id") @PathVariable("employeeId") Integer employeeId,
            @RequestBody EmployeeUpdateRequest request
    ) {
        employeeService.updateEmployee(employeeId, request);
        return employeeId;
    }

    @Operation(summary = "특정 부서의 직원들 급여 인상 API")
    @PutMapping("/department/{departmentId}/update-salary")
    public void updateSalary(
            @Parameter(description = "부서 id") @PathVariable("departmentId") Integer departmentId,
            @RequestBody DepartmentUpdateSalaryRequest request
    ) {
        employeeService.updateSalaryOfDepartment(departmentId, request);
    }

}
