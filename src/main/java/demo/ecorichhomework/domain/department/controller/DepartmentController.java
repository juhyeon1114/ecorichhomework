package demo.ecorichhomework.domain.department.controller;

import demo.ecorichhomework.domain.department.controller.dto.DepartmentSearchResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "부서(Department) API", description = "부서에 대한 정보를 조회하고, 부서에 대한 정보를 수정할 수 있습니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/department")
public class DepartmentController {

    @GetMapping("/search")
    public PagedModel<DepartmentSearchResponse> searchDepartments() {
        // todo: 부서 조회 API (위치 정보로도 검색이 가능하도록)
        return null;
    }

    @GetMapping("/{departmentId}/update-salary")
    public void updateSalary(@PathVariable("departmentId") Integer departmentId) {
        // todo: 특정 부서의 급여를 특정 비율로 인상 할 수 있는 할 수 있는 API 구현
    }

}
