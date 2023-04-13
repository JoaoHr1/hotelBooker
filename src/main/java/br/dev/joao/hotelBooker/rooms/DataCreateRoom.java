package br.dev.joao.hotelBooker.rooms;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DataCreateRoom(
        @NotBlank
        String name,

        @NotBlank
        String description,

        @NotBlank
        RoomType roomType,

        @NotNull
        BigDecimal pricePerNight


) {
}
