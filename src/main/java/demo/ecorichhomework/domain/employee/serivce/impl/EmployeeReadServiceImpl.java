package demo.ecorichhomework.domain.employee.serivce.impl;

import demo.ecorichhomework.domain.employee.data.dto.EmployeeDetailResponse;
import demo.ecorichhomework.domain.employee.repository.EmployeeDetailRepository;
import demo.ecorichhomework.domain.employee.serivce.EmployeeDetailReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EmployeeReadServiceImpl implements EmployeeDetailReadService {

    private final EmployeeDetailRepository employeeDetailRepository;

    @Override
    public EmployeeDetailResponse getEmployeeDetailResponse(Integer employeeId) {
        return employeeDetailRepository.getEmployeeDetailResponse(employeeId);
    }

}
