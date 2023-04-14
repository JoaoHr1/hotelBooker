package br.dev.joao.hotelBooker.guests;

import br.dev.joao.hotelBooker.rooms.Room;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DataUpdateGuest(
        @NotNull
        long id,

        String name,
        String cpf,
        LocalDateTime checkinDate,
        LocalDateTime checkoutDate,
        Long RoomId
) {
}
