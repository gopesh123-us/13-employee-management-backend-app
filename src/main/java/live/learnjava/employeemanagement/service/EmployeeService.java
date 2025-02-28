package live.learnjava.employeemanagement.service;

import java.util.Optional;

import org.springframework.hateoas.EntityModel;

import live.learnjava.employeemanagement.bindings.CustomPagedModelDTO;
import live.learnjava.employeemanagement.bindings.EmployeeEntityDTO;

public interface EmployeeService {
	EmployeeEntityDTO saveEmployee(EmployeeEntityDTO theEmployeeEntityDTO);

	CustomPagedModelDTO<EntityModel<EmployeeEntityDTO>> findAllEmployees(int page, int size, String sortby,
			String direction);

	Optional<EmployeeEntityDTO> findById(Long theEmployeeId);

	EmployeeEntityDTO updateEmployee(EmployeeEntityDTO theEmployeeEntityDTO);

	void deleteEmployeeById(Long theEmployeeId);

}
