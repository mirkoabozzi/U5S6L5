package mirkoabozzi.U5S6L5.controllers;

import mirkoabozzi.U5S6L5.dto.EmployeesDTO;
import mirkoabozzi.U5S6L5.entities.Employee;
import mirkoabozzi.U5S6L5.exceptions.BadRequestException;
import mirkoabozzi.U5S6L5.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;

    //POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Employee saveEmployee(@RequestBody @Validated EmployeesDTO payload, BindingResult validation) {
        if (validation.hasErrors()) {
            String msg = validation.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.joining());
            throw new BadRequestException("Payload error: " + msg);
        } else {
            return employeesService.save(payload);
        }
    }

}
