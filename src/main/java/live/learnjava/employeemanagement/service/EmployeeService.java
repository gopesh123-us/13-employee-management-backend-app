package live.learnjava.employeemanagement.service;

import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;

import live.learnjava.employeemanagement.bindings.EmployeeEntityDTO;

public interface EmployeeService {
	EmployeeEntityDTO saveEmployee(EmployeeEntityDTO theEmployeeEntityDTO);

	PagedModel<EntityModel<EmployeeEntityDTO>> findAllEmployees(int page, int size, String sortby, String direction);

	Optional<EmployeeEntityDTO> findById(Long theEmployeeId);

	EmployeeEntityDTO updateEmployee(EmployeeEntityDTO theEmployeeEntityDTO);

	void deleteEmployeeById(Long theEmployeeId);

}
