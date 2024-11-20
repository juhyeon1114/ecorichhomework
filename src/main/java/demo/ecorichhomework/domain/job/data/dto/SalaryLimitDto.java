package demo.ecorichhomework.domain.job.data.dto;

import java.math.BigDecimal;

public record SalaryLimitDto(
        BigDecimal minSalary,
        BigDecimal maxSalary
) {

    public void validateProperSalary(BigDecimal salary) {
        if (salary.compareTo(minSalary) < 0 || salary.compareTo(maxSalary) > 0) {
            throw new IllegalArgumentException("범위를 벗어나는 급여입니다.");
        }
    }

}
