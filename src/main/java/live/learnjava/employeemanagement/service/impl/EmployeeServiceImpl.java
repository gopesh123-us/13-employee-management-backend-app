package live.learnjava.employeemanagement.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import live.learnjava.employeemanagement.bindings.EmployeeEntityDTO;
import live.learnjava.employeemanagement.entities.EmployeeEntity;
import live.learnjava.employeemanagement.exceptions.ResourceNotFoundException;
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
		List<EmployeeEntity> employees = employeeRepo.findAll();
		if (employees.isEmpty()) {
			throw new ResourceNotFoundException("No Employees", HttpStatus.NOT_FOUND.toString());
		}
		employees.stream().map(EmployeeEntity::getEmail).forEach(System.out::println);
		List<EmployeeEntityDTO> employeesDtos = new ArrayList<EmployeeEntityDTO>();
		for (int i = 0; i < employees.size(); i++) {
			EmployeeEntityDTO dto = new EmployeeEntityDTO();
			BeanUtils.copyProperties(employees.get(i), dto);
			employeesDtos.add(dto);
			System.out.println(employeesDtos.get(i).getFirstName());
		}

		return employeesDtos;
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
