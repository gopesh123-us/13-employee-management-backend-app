package live.learnjava.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import live.learnjava.employeemanagement.bindings.CustomPagedResponseDTO;
import live.learnjava.employeemanagement.entities.EmployeeEntity;
import live.learnjava.employeemanagement.service.EmployeePagingService;

@RestController
@RequestMapping("/api/v1")
public class EmployeePagingOperationsController {
	// use service
	@Autowired
	private EmployeePagingService serviceRepo;
	@Autowired
	private PagedResourcesAssembler<EmployeeEntity> assembler;

	@GetMapping("/entities")
	public ResponseEntity<CustomPagedResponseDTO<EntityModel<EmployeeEntity>>> getEntities(
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "firstName") String sortby,
			@RequestParam(defaultValue = "asc") String direction) {
		Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortby).ascending()
				: Sort.by(sortby).descending();
		// create Pageable object
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<EmployeeEntity> thePage = serviceRepo.getAllPagedEmployees(pageable);

		PagedModel<EntityModel<EmployeeEntity>> pagedModel = assembler.toModel(thePage);

		CustomPagedResponseDTO.PageMetaDataCustom metaData = new CustomPagedResponseDTO.PageMetaDataCustom(
				thePage.isFirst(), thePage.isLast());

		CustomPagedResponseDTO<EntityModel<EmployeeEntity>> customDTO = new CustomPagedResponseDTO<EntityModel<EmployeeEntity>>(
				pagedModel, metaData);
		// extend PagedModel. Create a wrapper class, and add an inner static class, a
		// pojo class that will hold metadata.
		return ResponseEntity.ok(customDTO);
	}
}
