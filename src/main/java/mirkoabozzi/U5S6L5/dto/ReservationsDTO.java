package mirkoabozzi.U5S6L5.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record ReservationsDTO(
        @NotNull(message = "Employee required. ")
        UUID employeeId,
        @NotNull(message = "Trip is required. ")
        UUID tripId,
        @NotNull(message = "Date id required .")
        LocalDate date,
        String note
) {
}
