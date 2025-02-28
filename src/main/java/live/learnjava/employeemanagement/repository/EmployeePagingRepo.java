package live.learnjava.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import live.learnjava.employeemanagement.entities.EmployeeEntity;

public interface EmployeePagingRepo extends JpaRepository<EmployeeEntity, Long> {

}
