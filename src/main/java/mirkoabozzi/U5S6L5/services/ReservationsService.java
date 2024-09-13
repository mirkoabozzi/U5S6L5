package mirkoabozzi.U5S6L5.services;

import mirkoabozzi.U5S6L5.repositories.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationsService {
    @Autowired
    private ReservationsRepository reservationsRepository;
}
