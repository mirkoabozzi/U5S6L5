package mirkoabozzi.U5S6L5.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import mirkoabozzi.U5S6L5.enums.TripsState;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "trips")
@Data
public class Trip {
    @Id
    @GeneratedValue
    @Getter(AccessLevel.NONE)
    private UUID id;
    private String destination;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private TripsState state;
    
}
