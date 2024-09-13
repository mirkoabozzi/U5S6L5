package mirkoabozzi.U5S6L5.dto;

import jakarta.validation.constraints.NotNull;
import mirkoabozzi.U5S6L5.enums.TripsState;

import java.time.LocalDate;

public record TripsDTO(
        @NotNull(message = "Destination is required. ")
        String destination,
        @NotNull(message = "Date is required. ")
        LocalDate date,
        @NotNull(message = "State is required. ")
        TripsState state
) {
}
