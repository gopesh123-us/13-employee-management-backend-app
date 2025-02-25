package live.learnjava.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import live.learnjava.employeemanagement.bindings.EmployeeEntityDTO;
import live.learnjava.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeOperationsController {
	// use service

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/saveEmployee")
	ResponseEntity<EmployeeEntityDTO> saveEmployee(@RequestBody EmployeeEntityDTO theEmployeeEntityDTO) {
		EmployeeEntityDTO savedEmployeeEntityDTO = employeeService.saveEmployee(theEmployeeEntityDTO);
		return new ResponseEntity<EmployeeEntityDTO>(savedEmployeeEntityDTO, HttpStatus.OK);
	}
}

/*
 * 
 * EmployeeEntityDTO saveEmployee(EmployeeEntityDTO theEmployeeEntityDTO);
 * 
 * List<EmployeeEntityDTO> findAllEmployees();
 * 
 * Optional<EmployeeEntityDTO> findById(Long theEmployeeId);
 * 
 * EmployeeEntityDTO updateEmployee(EmployeeEntityDTO theEmployeeEntityDTO);
 * 
 * void deleteEmployeeById(Long theEmployeeId);
 */
