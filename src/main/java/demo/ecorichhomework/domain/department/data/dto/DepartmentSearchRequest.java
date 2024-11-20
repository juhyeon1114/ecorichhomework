package demo.ecorichhomework.domain.department.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "부서 조회를 위한 요청 객체")
public record DepartmentSearchRequest() {

}
