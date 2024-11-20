package demo.ecorichhomework.domain.department.data.dto;

import static demo.ecorichhomework.domain.department.data.QDepartment.department;
import static demo.ecorichhomework.domain.location.data.QCountry.country;
import static demo.ecorichhomework.domain.location.data.QLocation.location;
import static demo.ecorichhomework.domain.location.data.QRegion.region;

import com.querydsl.core.types.Predicate;
import demo.ecorichhomework.global.dto.PaginationRequestParam;
import org.springframework.data.domain.Pageable;

public record DepartmentSearchDto(
        String keyword,
        PaginationRequestParam param
) {

    public Pageable pageable() {
        return param.pageable();
    }

    public Predicate searchPredicate() {
        return department.departmentName.contains(keyword)
                .or(location.city.contains(keyword))
                .or(location.streetAddress.contains(keyword))
                .or(location.stateProvince.contains(keyword))
                .or(location.postalCode.contains(keyword))
                .or(country.countryName.contains(keyword))
                .or(region.regionName.contains(keyword));
    }

}
