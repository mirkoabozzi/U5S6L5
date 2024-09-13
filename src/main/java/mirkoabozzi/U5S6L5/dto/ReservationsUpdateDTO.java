package mirkoabozzi.U5S6L5.dto;

import java.time.LocalDate;

public record ReservationsUpdateDTO(
        LocalDate date,
        String note
) {
}
