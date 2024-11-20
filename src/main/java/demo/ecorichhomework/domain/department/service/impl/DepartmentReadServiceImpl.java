package demo.ecorichhomework.domain.department.service.impl;

import demo.ecorichhomework.domain.department.service.DepartmentReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DepartmentReadServiceImpl implements DepartmentReadService {


}
