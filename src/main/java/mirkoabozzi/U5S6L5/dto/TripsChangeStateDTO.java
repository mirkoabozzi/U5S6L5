package mirkoabozzi.U5S6L5.dto;

import jakarta.validation.constraints.NotNull;

public record TripsChangeStateDTO(
        @NotNull(message = "State is required. ")
        String state
) {
}
