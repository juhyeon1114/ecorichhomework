package demo.ecorichhomework.domain.department.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Schema(title = "부서 급여 인상 요청 객체")
public record DepartmentUpdateSalaryRequest(
        @Schema(title = "급여 인상률", example = "0% ~ 100%") @Max(100) @Min(0) Double increasePercentage
) {

    @JsonIgnore
    public Double increasePoint() {
        return increasePercentage / 100;
    }

}
