package live.learnjava.employeemanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import live.learnjava.employeemanagement.bindings.EmployeeEntityDTO;
import live.learnjava.employeemanagement.repository.EmployeeRepository;
import live.learnjava.employeemanagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public EmployeeEntityDTO saveEmployee(EmployeeEntityDTO theEmployeeEntityDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeEntityDTO> findAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<EmployeeEntityDTO> findById(Long theEmployeeId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public EmployeeEntityDTO updateEmployee(EmployeeEntityDTO theEmployeeEntityDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployeeById(Long theEmployeeId) {
		// TODO Auto-generated method stub

	}

}
