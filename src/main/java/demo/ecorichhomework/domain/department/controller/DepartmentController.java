package demo.ecorichhomework.domain.department.controller;

import demo.ecorichhomework.domain.department.data.dto.DepartmentSearchDto;
import demo.ecorichhomework.domain.department.data.dto.DepartmentSearchResponse;
import demo.ecorichhomework.domain.department.service.DepartmentReadService;
import demo.ecorichhomework.global.dto.PaginationRequestParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "부서(Department) API", description = "부서에 대한 정보를 조회하고, 부서에 대한 정보를 수정할 수 있습니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentReadService departmentReadService;

    @Operation(
            summary = "부서 검색 API",
            description = "검색어로 부서와 부서의 위치를 조회할 수 있는 API"
    )
    @GetMapping("/search")
    public PagedModel<DepartmentSearchResponse> searchDepartments(
            @Parameter(description = "검색어") @RequestParam("keyword") String keyword,
            @Parameter(description = "페이지") @RequestParam(value = "page", defaultValue = "0") Integer page,
            @Parameter(description = "한 페이지당 크기") @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        DepartmentSearchDto searchDto = new DepartmentSearchDto(keyword, new PaginationRequestParam(page, size));
        return departmentReadService.searchDepartmentsByKeyword(searchDto);
    }

}
