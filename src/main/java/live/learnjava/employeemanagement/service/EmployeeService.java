package live.learnjava.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import live.learnjava.employeemanagement.bindings.EmployeeEntityDTO;

public interface EmployeeService {
	EmployeeEntityDTO saveEmployee(EmployeeEntityDTO theEmployeeEntityDTO);

	List<EmployeeEntityDTO> findAllEmployees();

	Optional<EmployeeEntityDTO> findById(Long theEmployeeId);

	EmployeeEntityDTO updateEmployee(EmployeeEntityDTO theEmployeeEntityDTO);

	void deleteEmployeeById(Long theEmployeeId);
}
