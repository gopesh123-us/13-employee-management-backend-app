package live.learnjava.employeemanagement.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "EMS_EMPLOYEE")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "first_name", length = 30)
	private String firstName;

	@Column(name = "last_name", length = 30)
	private String lastName;

	@Column(name = "email", length = 50)
	private String email;

	@CreationTimestamp()
	@Column(insertable = true, updatable = false)
	private LocalDate createdAt;

	@UpdateTimestamp()
	@Column(insertable = false, updatable = true)
	private LocalDate updatedAt;

	@CreatedBy()
	@Column(length = 30)
	private String createdBy;

	@LastModifiedBy()
	@Column(length = 30)
	private String updatedBy;

}
