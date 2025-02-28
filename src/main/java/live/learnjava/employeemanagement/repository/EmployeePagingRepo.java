package live.learnjava.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import live.learnjava.employeemanagement.entities.EmployeeEntity;

@Repository
public interface EmployeePagingRepo extends JpaRepository<EmployeeEntity, Long> {

}
