package br.dev.joao.hotelBooker.rooms;

import java.math.BigDecimal;

public record DataDetailRoom(Long id, String name, String description, RoomType roomType, BigDecimal pricePerNight, Boolean isAvailable) {
    public DataDetailRoom(Room room) {
        this(room.getId(), room.getName(), room.getDescription(), room.getRoomType(), room.getPricePerNight(), room.getIsAvailable());
    }
}
