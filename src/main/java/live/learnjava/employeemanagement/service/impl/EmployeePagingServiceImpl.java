package live.learnjava.employeemanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import live.learnjava.employeemanagement.entities.EmployeeEntity;
import live.learnjava.employeemanagement.repository.EmployeePagingRepo;
import live.learnjava.employeemanagement.service.EmployeePagingService;

@Service
public class EmployeePagingServiceImpl implements EmployeePagingService {
	// use repo

	@Autowired
	private EmployeePagingRepo repo;

	@Override
	public Page<EmployeeEntity> getAllPagedEmployees(Pageable pageable) {

		return repo.findAll(pageable);
	}

}
