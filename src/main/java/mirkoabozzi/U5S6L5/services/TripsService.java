package mirkoabozzi.U5S6L5.services;

import mirkoabozzi.U5S6L5.repositories.TripsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripsService {
    @Autowired
    private TripsRepository tripsRepository;
}
