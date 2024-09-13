package mirkoabozzi.U5S6L5.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "reservations")
@Data
public class Reservation {
    @Id
    @GeneratedValue
    @Getter(AccessLevel.NONE)
    private UUID id;
    private LocalDate date;
    private String note;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;
}
