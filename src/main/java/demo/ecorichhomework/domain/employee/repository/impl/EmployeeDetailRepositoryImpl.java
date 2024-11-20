package demo.ecorichhomework.domain.employee.repository.impl;

import static demo.ecorichhomework.domain.employee.data.QEmployeeDetail.employeeDetail;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import demo.ecorichhomework.domain.employee.data.dto.EmployeeDetailResponse;
import demo.ecorichhomework.domain.employee.repository.EmployeeDetailRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmployeeDetailRepositoryImpl implements EmployeeDetailRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<EmployeeDetailResponse> findEmployeeDetailResponse(Integer employeeId) {
        return Optional.ofNullable(queryFactory.select(Projections.constructor(EmployeeDetailResponse.class,
                                employeeDetail.employeeId,
                                employeeDetail.jobTitle,
                                employeeDetail.departmentName,
                                employeeDetail.firstName,
                                employeeDetail.lastName,
                                employeeDetail.salary,
                                employeeDetail.city,
                                employeeDetail.stateProvince,
                                employeeDetail.countryName,
                                employeeDetail.regionName
                        ))
                        .from(employeeDetail)
                        .where(employeeDetail.employeeId.eq(employeeId))
                        .fetchFirst()
        );
    }
}
