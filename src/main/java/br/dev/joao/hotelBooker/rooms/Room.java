package br.dev.joao.hotelBooker.rooms;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "rooms")
@Entity(name = "Room")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Room {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private BigDecimal pricePerNight;

    private Boolean isAvailable;

    public Room(DataCreateRoom room) {
        this.isAvailable = true;
        this.name = room.name();
        this.description = room.description();
        this.roomType = room.roomType();
        this.pricePerNight = room.pricePerNight();

    }

}
