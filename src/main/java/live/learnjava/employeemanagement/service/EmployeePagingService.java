package live.learnjava.employeemanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import live.learnjava.employeemanagement.entities.EmployeeEntity;

public interface EmployeePagingService {

	Page<EmployeeEntity> getAllPagedEmployees(Pageable pageable);

}
