package live.learnjava.employeemanagement.dataloaders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import live.learnjava.employeemanagement.entities.EmployeeEntity;
import live.learnjava.employeemanagement.repository.EmployeeRepository;

@Component
@Profile("dev")
public class DummyDataLoader implements CommandLineRunner {

	// use repository
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		if ((employeeRepository.count() == 0)) {
			generateData();
		}

	}

	private void generateData() {
		EmployeeEntity employee1 = new EmployeeEntity(null, "Ramesh", "Fadatare", "ramesh@gmail.com", null, null,
				"system", "system");

		EmployeeEntity employee2 = new EmployeeEntity(null, "Sandeep", "Kukreja", "sandeep@gmail.com", null, null,
				"system", "system");

		EmployeeEntity employee3 = new EmployeeEntity(null, "John", "Lotwick", "john@gmail.com", null, null, "system",
				"system");
		employeeRepository.saveAll(List.of(employee1, employee2, employee3));
		System.out.println("Dummy data inserted!");
	}

}
