package br.dev.joao.hotelBooker.guests;


import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record DataCreateGuest(
        @NotBlank
        String name,

        @NotBlank
        @Size(min = 11, max = 11)
        @Pattern(regexp = "\\d{11}")
        String cpf,

        @NotNull
        LocalDateTime checkinDate,

        @NotNull
        @Future
        LocalDateTime checkoutDate,

        Long roomId

) {
}
