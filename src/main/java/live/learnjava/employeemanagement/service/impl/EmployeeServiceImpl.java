package live.learnjava.employeemanagement.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import live.learnjava.employeemanagement.bindings.CustomPagedModelDTO;
import live.learnjava.employeemanagement.bindings.EmployeeEntityDTO;
import live.learnjava.employeemanagement.entities.EmployeeEntity;
import live.learnjava.employeemanagement.exceptions.ResourceNotFoundException;
import live.learnjava.employeemanagement.repository.EmployeeRepository;
import live.learnjava.employeemanagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Autowired
	private PagedResourcesAssembler<EmployeeEntityDTO> assembler;

	@Override
	public EmployeeEntityDTO saveEmployee(EmployeeEntityDTO theEmployeeEntityDTO) {

		EmployeeEntity employeeEntity = new EmployeeEntity();

		BeanUtils.copyProperties(theEmployeeEntityDTO, employeeEntity);

		EmployeeEntity savedEmployee = employeeRepo.save(employeeEntity);

		EmployeeEntityDTO employeeEntityDto = new EmployeeEntityDTO();

		BeanUtils.copyProperties(savedEmployee, employeeEntityDto);

		return employeeEntityDto;
	}

	@Override
	public CustomPagedModelDTO<EntityModel<EmployeeEntityDTO>> findAllEmployees(int page, int size, String sortby,
			String direction) {

		// create sort object
		Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortby).ascending()
				: Sort.by(sortby).descending();

		// create Pageable object
		Pageable pageable = PageRequest.of(page, size, sort);

		// create CustomPagedDTO from pagedObject

		/*
		 * // pass Pageable to employeeRepo Page<EmployeeEntity> employeePage =
		 * employeeRepo.findAll(pageable); if (employeePage.isEmpty() == true) {
		 * System.out.println("NO EMPLOYEE!"); System.out.println(pageable); throw new
		 * ResourceNotFoundException("No employees",
		 * HttpStatus.NOT_FOUND.name().toString()); }
		 * 
		 * List<EmployeeEntityDTO> employeesDtosList = new
		 * ArrayList<EmployeeEntityDTO>(); employeePage.stream().forEach((employee) -> {
		 * EmployeeEntityDTO dto = new EmployeeEntityDTO();
		 * BeanUtils.copyProperties(employee, dto); employeesDtosList.add(dto);
		 * System.out.println(dto.getFirstName()); });
		 */

		Page<EmployeeEntityDTO> employeesDtosPage = employeeRepo.findAllEmployees(pageable);

		PagedModel<EntityModel<EmployeeEntityDTO>> pagedModel = assembler.toModel(employeesDtosPage);

		CustomPagedModelDTO.PagedMetaData pagedMetaData = new CustomPagedModelDTO.PagedMetaData(
				employeesDtosPage.isFirst(), employeesDtosPage.isLast());

		CustomPagedModelDTO<EntityModel<EmployeeEntityDTO>> customPagedModelDTO = new CustomPagedModelDTO<EntityModel<EmployeeEntityDTO>>(
				pagedModel, pagedMetaData);

		return customPagedModelDTO;

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

//@Override
//public List<EmployeeEntityDTO> findAllEmployees() {
//	List<EmployeeEntity> employees = employeeRepo.findAll();
//	if (employees.isEmpty()) {
//		throw new ResourceNotFoundException("No Employees", HttpStatus.NOT_FOUND.toString());
//	}
//	employees.stream().map(EmployeeEntity::getEmail).forEach(System.out::println);
//	List<EmployeeEntityDTO> employeesDtos = new ArrayList<EmployeeEntityDTO>();
//	for (int i = 0; i < employees.size(); i++) {
//		EmployeeEntityDTO dto = new EmployeeEntityDTO();
//		BeanUtils.copyProperties(employees.get(i), dto);
//		employeesDtos.add(dto);
//		System.out.println(employeesDtos.get(i).getFirstName());
//	}
//
//	return employeesDtos;
//}
