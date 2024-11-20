package demo.ecorichhomework.domain.employee.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

@Schema(title = "직원 상세 정보 응답 객체")
public record EmployeeDetailResponse(
        @Schema(title = "직원 고유 id") Integer employeeId,
        @Schema(title = "직업명") String jobTitle,
        @Schema(title = "부서명") String departmentName,
        @Schema(title = "직원의 이름") String firstName,
        @Schema(title = "직원의 성씨") String lastName,
        @Schema(title = "직원의 급여") BigDecimal salary,
        @Schema(title = "부서 위치 (시)") String city,
        @Schema(title = "부서 위치 (주)") String stateProvince,
        @Schema(title = "부서 위치 (국가)") String countryName,
        @Schema(title = "부서 위치 (대륙)") String regionName
) {

}
