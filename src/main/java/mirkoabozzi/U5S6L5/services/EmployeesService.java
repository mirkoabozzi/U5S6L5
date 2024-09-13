package mirkoabozzi.U5S6L5.services;

import mirkoabozzi.U5S6L5.dto.EmployeesDTO;
import mirkoabozzi.U5S6L5.entities.Employee;
import mirkoabozzi.U5S6L5.exceptions.BadRequestException;
import mirkoabozzi.U5S6L5.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeesService {
    @Autowired
    private EmployeesRepository employeesRepository;

    //POST
    public Employee save(EmployeesDTO payload) {
        if (employeesRepository.existsByEmail(payload.email()))
            throw new BadRequestException("Email " + payload.email() + " already on DB");
        Employee newEmployee = new Employee(payload.username(), payload.name(), payload.surname(), payload.email(), "https://ui-avatars.com/api/?name=" + payload.name() + "+" + payload.surname());
        return this.employeesRepository.save(newEmployee);
    }

}
