package mirkoabozzi.U5S6L5.services;

import mirkoabozzi.U5S6L5.dto.ReservationsDTO;
import mirkoabozzi.U5S6L5.entities.Employee;
import mirkoabozzi.U5S6L5.entities.Reservation;
import mirkoabozzi.U5S6L5.entities.Trip;
import mirkoabozzi.U5S6L5.repositories.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
