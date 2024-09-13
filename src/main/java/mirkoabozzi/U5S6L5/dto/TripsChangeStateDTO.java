package mirkoabozzi.U5S6L5.dto;

import jakarta.validation.constraints.NotNull;
import mirkoabozzi.U5S6L5.enums.TripsState;

public record TripsChangeStateDTO(
        @NotNull(message = "State is required. ")
        TripsState state
) {
}
