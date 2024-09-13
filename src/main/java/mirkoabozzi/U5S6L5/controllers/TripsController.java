package mirkoabozzi.U5S6L5.controllers;

import mirkoabozzi.U5S6L5.services.TripsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trips")
public class TripsController {
    @Autowired
    private TripsService tripsService;
}
