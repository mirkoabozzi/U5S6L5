package mirkoabozzi.U5S6L5.services;

import mirkoabozzi.U5S6L5.dto.ReservationsDTO;
import mirkoabozzi.U5S6L5.entities.Employee;
import mirkoabozzi.U5S6L5.entities.Reservation;
import mirkoabozzi.U5S6L5.entities.Trip;
import mirkoabozzi.U5S6L5.exceptions.NotFoundException;
import mirkoabozzi.U5S6L5.repositories.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReservationsService {
    @Autowired
    private ReservationsRepository reservationsRepository;
    @Autowired
    private EmployeesService employeesService;
    @Autowired
    private TripsService tripsService;

    //POST
    public Reservation save(ReservationsDTO payload) {
        Employee employeeFound = this.employeesService.findById(payload.employeeId());
        Trip tripFound = this.tripsService.findById(payload.tripId());
        Reservation reservation = new Reservation(payload.date(), payload.note(), employeeFound, tripFound);
        return this.reservationsRepository.save(reservation);
    }

    //GET
    public Page<Reservation> findAll(int page, int size, String shortBy) {
        if (page > 50) page = 50;
        Pageable pageable = PageRequest.of(page, size, Sort.by(shortBy));
        return this.reservationsRepository.findAll(pageable);
    }

    //GET BY ID
    public Reservation findById(UUID id) {
        return reservationsRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    //DELETE
    public void delete(UUID id) {
        this.reservationsRepository.delete(this.findById(id));
    }
}
