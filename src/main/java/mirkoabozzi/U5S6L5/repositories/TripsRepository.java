package mirkoabozzi.U5S6L5.repositories;

import mirkoabozzi.U5S6L5.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface TripsRepository extends JpaRepository<Trip, UUID> {

    boolean existsByDestinationAndDate(String destination, LocalDate date);
}
