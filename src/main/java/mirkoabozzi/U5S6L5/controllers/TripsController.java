package mirkoabozzi.U5S6L5.controllers;

import mirkoabozzi.U5S6L5.dto.TripsDTO;
import mirkoabozzi.U5S6L5.entities.Trip;
import mirkoabozzi.U5S6L5.exceptions.BadRequestException;
import mirkoabozzi.U5S6L5.services.TripsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/trips")
public class TripsController {
    @Autowired
    private TripsService tripsService;

    //POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Trip saveTrip(@RequestBody @Validated TripsDTO payload, BindingResult validation) {
        if (validation.hasErrors()) {
            String msg = validation.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.joining());
            throw new BadRequestException("Payload error: " + msg);
        } else {
            return tripsService.save(payload);
        }

    }

    //GET
    @GetMapping
    private Page<Trip> getTrips(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size,
                                @RequestParam(defaultValue = "destination") String sortBy) {
        return this.tripsService.findAll(page, size, sortBy);
    }
}
