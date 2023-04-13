package br.dev.joao.hotelBooker.rooms;

import java.math.BigDecimal;

public record DataListRoom(
        Long id, String name, RoomType roomType, String description, BigDecimal pricePerNight, Boolean isAvailable
) {
    public DataListRoom(Room room) {
        this(room.getId(), room.getName(), room.getRoomType(), room.getDescription(), room.getPricePerNight(), room.getIsAvailable());
    }

}
