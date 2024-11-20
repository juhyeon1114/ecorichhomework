package demo.ecorichhomework.domain.department.service;

import demo.ecorichhomework.domain.department.data.dto.DepartmentSearchDto;
import demo.ecorichhomework.domain.department.data.dto.DepartmentSearchResponse;
import org.springframework.data.web.PagedModel;

public interface DepartmentReadService {

    PagedModel<DepartmentSearchResponse> searchDepartmentsByKeyword(DepartmentSearchDto searchDto);

}
