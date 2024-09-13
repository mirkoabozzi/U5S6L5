package mirkoabozzi.U5S6L5.dto;

import jakarta.validation.constraints.NotNull;

public record EmployeesDTO(
        @NotNull(message = "Username is required")
        String username,
        @NotNull(message = "Name is required")
        String name,
        @NotNull(message = "Surname is required")
        String surname,
        @NotNull(message = "Email is required")
        String email
) {
}
