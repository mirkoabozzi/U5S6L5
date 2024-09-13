package mirkoabozzi.U5S6L5.services;

import mirkoabozzi.U5S6L5.dto.TripsDTO;
import mirkoabozzi.U5S6L5.entities.Trip;
import mirkoabozzi.U5S6L5.exceptions.BadRequestException;
import mirkoabozzi.U5S6L5.repositories.TripsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripsService {
    @Autowired
    private TripsRepository tripsRepository;

    //POST
    public Trip save(TripsDTO payload) {
        if (tripsRepository.existsByDestinationAndDate(payload.destination(), payload.date()))
            throw new BadRequestException("This trip " + payload.destination() + " on this date " + payload.date() + " already exists on DB");
        Trip trip = new Trip(payload.destination(), payload.date(), payload.state());
        return this.tripsRepository.save(trip);
    }
}
