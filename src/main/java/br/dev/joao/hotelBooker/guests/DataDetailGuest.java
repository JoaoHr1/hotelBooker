package br.dev.joao.hotelBooker.guests;

import br.dev.joao.hotelBooker.rooms.Room;

import java.time.LocalDateTime;

public record DataDetailGuest(Long id, String name, String cpf, LocalDateTime checkinDate, LocalDateTime checkoutDate, Long roomId) {
    public DataDetailGuest(Guest guest) {
        this(guest.getId(), guest.getName(), guest.getCpf(), guest.getCheckinDate(), guest.getCheckoutDate(), guest.getRoomId());
    }
}
