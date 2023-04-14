package br.dev.joao.hotelBooker.rooms;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DataUpdateRoom(
        @NotNull
        Long id,

        String name,
        String description,
        RoomType roomType,
        BigDecimal pricePerNight

) {
}
