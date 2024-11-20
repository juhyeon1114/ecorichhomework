package demo.ecorichhomework.domain.department.repository.impl;

import static demo.ecorichhomework.domain.department.data.QDepartment.department;
import static demo.ecorichhomework.domain.location.data.QCountry.country;
import static demo.ecorichhomework.domain.location.data.QLocation.location;
import static demo.ecorichhomework.domain.location.data.QRegion.region;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import demo.ecorichhomework.domain.department.data.Department;
import demo.ecorichhomework.domain.department.data.dto.DepartmentSearchDto;
import demo.ecorichhomework.domain.department.data.dto.DepartmentSearchResponse;
import demo.ecorichhomework.domain.department.repository.DepartmentRepository;
import demo.ecorichhomework.domain.department.repository.jpa.DepartmentJpaRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DepartmentRepositoryImpl implements DepartmentRepository {

    private final DepartmentJpaRepository departmentJpaRepository;
    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Department> findById(Integer departmentId) {
        return departmentJpaRepository.findById(departmentId);
    }

    @Override
    public Long getDepartmentSearchCount(DepartmentSearchDto searchDto) {
        return queryFactory
                .select(Wildcard.count)
                .from(department)
                .leftJoin(location).on(department.locationId.eq(location.locationId))
                .leftJoin(country).on(location.countryId.eq(country.countryId))
                .leftJoin(region).on(country.regionId.eq(region.regionId))
                .where(searchDto.searchPredicate())
                .fetchFirst();
    }

    @Override
    public List<DepartmentSearchResponse> getDepartmentSearchResponseList(DepartmentSearchDto searchDto) {
        Pageable pageable = searchDto.pageable();
        return queryFactory.select(Projections.constructor(DepartmentSearchResponse.class,
                        department.departmentId,
                        department.departmentName,
                        location.streetAddress,
                        location.postalCode,
                        location.city,
                        location.stateProvince,
                        country.countryName,
                        region.regionName
                ))
                .from(department)
                .leftJoin(location).on(department.locationId.eq(location.locationId))
                .leftJoin(country).on(location.countryId.eq(country.countryId))
                .leftJoin(region).on(country.regionId.eq(region.regionId))
                .where(searchDto.searchPredicate())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(department.departmentName.asc())
                .fetch();
    }

}
