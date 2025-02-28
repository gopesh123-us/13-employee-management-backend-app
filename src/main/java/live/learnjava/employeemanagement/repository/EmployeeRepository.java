package live.learnjava.employeemanagement.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import live.learnjava.employeemanagement.bindings.EmployeeEntityDTO;
import live.learnjava.employeemanagement.entities.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

	@Query("SELECT new live.learnjava.employeemanagement.bindings.EmployeeEntityDTO(e.id, e.firstName, e.lastName, e.email) FROM EmployeeEntity e")
	Page<EmployeeEntityDTO> findAllEmployees(Pageable pageable);

}
