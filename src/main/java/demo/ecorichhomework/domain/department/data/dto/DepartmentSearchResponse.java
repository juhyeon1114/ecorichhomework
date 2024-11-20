package demo.ecorichhomework.domain.department.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "부서 조회에 대한 응답 객체")
public record DepartmentSearchResponse(
        Integer departmentId,
        String departmentName,
        String streetAddress,
        String postalCode,
        String city,
        String stateProvince,
        String countryName,
        String regionName
) {

}
