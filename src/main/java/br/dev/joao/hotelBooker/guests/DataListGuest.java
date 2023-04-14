package br.dev.joao.hotelBooker.guests;

import br.dev.joao.hotelBooker.rooms.Room;

import java.time.LocalDateTime;

public record DataListGuest(
        Long id, String name, String cpf, LocalDateTime checkinDate, LocalDateTime checkoutDate, Long roomId
) {
    public DataListGuest(Guest guest) {
        this(guest.getId(), guest.getName(), guest.getCpf(), guest.getCheckinDate(), guest.getCheckoutDate(), guest.getRoomId());
    }
}
