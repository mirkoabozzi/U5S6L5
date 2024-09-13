package mirkoabozzi.U5S6L5.repositories;

import mirkoabozzi.U5S6L5.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, UUID> {
}
