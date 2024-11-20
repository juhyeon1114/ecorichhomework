package demo.ecorichhomework.domain.employee.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(title = "직원 정보 수정 객체")
public record EmployeeUpdateRequest(
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        @Schema(title = "고용일") LocalDate hireDate,
        @Schema(title = "급여") BigDecimal salary,
        @Schema(title = "성과급 비율") BigDecimal commissionPct,
        @Schema(title = "직책 id") String jobId,
        @Schema(title = "매니저 id") Integer managerId,
        @Schema(title = "부서 id") Integer departmentId
) {

}
