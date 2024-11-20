package demo.ecorichhomework.domain.department.service.impl;

import demo.ecorichhomework.domain.department.data.dto.DepartmentSearchDto;
import demo.ecorichhomework.domain.department.data.dto.DepartmentSearchResponse;
import demo.ecorichhomework.domain.department.repository.DepartmentRepository;
import demo.ecorichhomework.domain.department.service.DepartmentReadService;
import demo.ecorichhomework.global.utils.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DepartmentReadServiceImpl implements DepartmentReadService {

    private final DepartmentRepository departmentRepository;

    @Override
    public PagedModel<DepartmentSearchResponse> searchDepartmentsByKeyword(DepartmentSearchDto searchDto) {
        Pageable pageable = searchDto.pageable();
        return PageUtils.pagination(
                departmentRepository.getDepartmentSearchResponseList(searchDto),
                departmentRepository.getDepartmentSearchCount(searchDto),
                pageable
        );
    }

}
