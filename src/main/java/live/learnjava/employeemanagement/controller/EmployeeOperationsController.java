package live.learnjava.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import live.learnjava.employeemanagement.bindings.EmployeeEntityDTO;
import live.learnjava.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeOperationsController {
	// use service
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/saveEmployee")
	ResponseEntity<EmployeeEntityDTO> saveEmployee(@RequestBody EmployeeEntityDTO theEmployeeEntityDTO) {
		EmployeeEntityDTO savedEmployeeEntityDTO = employeeService.saveEmployee(theEmployeeEntityDTO);
		return new ResponseEntity<EmployeeEntityDTO>(savedEmployeeEntityDTO, HttpStatus.OK);
	}

	// @formatter:off
	@GetMapping("/findAllEmployees")
	ResponseEntity<PagedModel<EntityModel<EmployeeEntityDTO>>> findAllEmployees(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, 
			@RequestParam(defaultValue = "id") String sortby,
			@RequestParam(defaultValue = "asc") String direction) {
		PagedModel<EntityModel<EmployeeEntityDTO>> employees = employeeService.findAllEmployees(page, size, sortby, direction);
		return new ResponseEntity<PagedModel<EntityModel<EmployeeEntityDTO>>>(employees, HttpStatus.OK);
	}
	// @formatter: on
}

/*
 * 
 * EmployeeEntityDTO saveEmployee(EmployeeEntityDTO theEmployeeEntityDTO); -
 * DONE!
 * 
 * List<EmployeeEntityDTO> findAllEmployees(); - DONE!
 * 
 * Optional<EmployeeEntityDTO> findById(Long theEmployeeId);
 * 
 * EmployeeEntityDTO updateEmployee(EmployeeEntityDTO theEmployeeEntityDTO);
 * 
 * void deleteEmployeeById(Long theEmployeeId);
 */
