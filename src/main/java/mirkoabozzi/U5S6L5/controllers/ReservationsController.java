package mirkoabozzi.U5S6L5.controllers;

import mirkoabozzi.U5S6L5.dto.ReservationsDTO;
import mirkoabozzi.U5S6L5.entities.Reservation;
import mirkoabozzi.U5S6L5.exceptions.BadRequestException;
import mirkoabozzi.U5S6L5.services.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservations")
public class ReservationsController {
    @Autowired
    private ReservationsService reservationsService;

    //POST RESERVATION
    @PostMapping
    private Reservation saveReservation(@RequestBody @Validated ReservationsDTO payload, BindingResult validation) {
        if (validation.hasErrors()) {
            String msg = validation.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.joining(" ."));
            throw new BadRequestException("Payload error: " + msg);
        } else {
            return reservationsService.save(payload);
        }
    }

    //GET
    @GetMapping
    private Page<Reservation> getReservations(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size,
                                              @RequestParam(defaultValue = "date") String sortBy) {
        return this.reservationsService.findAll(page, size, sortBy);
    }

    //GET BY ID
    @GetMapping("/{id}")
    public Reservation findById(@PathVariable UUID id) {
        return reservationsService.findById(id);
    }

    //DELETE

}
