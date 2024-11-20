package demo.ecorichhomework.domain.employee.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Schema(title = "직원의 과거 이력 조회 응답 객체")
public record JobHistoryResponse(
        @Schema(title = "직원 id") Integer employeeId,
        @Schema(title = "근무 시작일") LocalDate startDate,
        @Schema(title = "근무 종료일") LocalDate endDate,
        @Schema(title = "직업명") String jobTitle,
        @Schema(title = "부서명") String departmentName
) {

}
