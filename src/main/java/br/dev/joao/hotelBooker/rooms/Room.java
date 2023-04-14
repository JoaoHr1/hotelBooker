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
@Embeddable
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

    public void isAvailable() {
        if (this.isAvailable != true) {
            this.isAvailable = true;
        }
    }

    public void IsNotAvailable() {
        this.isAvailable = false;
    }

    public void updateData(DataUpdateRoom rooms) {
        if (rooms.name() != null) {
            this.name = rooms.name();
        }
        if (rooms.description() != null) {
            this.description = rooms.description();
        }
        if (rooms.roomType() != null) {
            this.roomType = rooms.roomType();
        }
        if (rooms.pricePerNight() != null) {
            this.pricePerNight = rooms.pricePerNight();
        }
    }

}
