package mirkoabozzi.U5S6L5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "employees")
@Data
public class Employee {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private String avatar;
}
