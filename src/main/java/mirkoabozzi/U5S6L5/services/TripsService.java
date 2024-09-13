package mirkoabozzi.U5S6L5.services;

import mirkoabozzi.U5S6L5.dto.TripsDTO;
import mirkoabozzi.U5S6L5.entities.Trip;
import mirkoabozzi.U5S6L5.exceptions.BadRequestException;
import mirkoabozzi.U5S6L5.exceptions.NotFoundException;
import mirkoabozzi.U5S6L5.repositories.TripsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    //GET
    public Page<Trip> findAll(int page, int size, String sortBy) {
        if (page > 50) page = 50;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.tripsRepository.findAll(pageable);
    }

    //GET BY ID
    public Trip findById(UUID id) {
        return tripsRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    //PUT
    public Trip update(UUID id, TripsDTO payload) {
        Trip found = this.findById(id);
        found.setDestination(payload.destination());
        found.setDate(payload.date());
        found.setState(payload.state());
        return this.tripsRepository.save(found);
    }

    //DELETE
    public void delete(UUID id) {
        this.tripsRepository.delete(this.findById(id));
    }
}
