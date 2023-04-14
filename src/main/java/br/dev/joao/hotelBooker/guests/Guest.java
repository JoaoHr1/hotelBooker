package br.dev.joao.hotelBooker.guests;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "guests")
@Entity(name = "Guest")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Guest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cpf;
    private LocalDateTime checkinDate;
    private LocalDateTime checkoutDate;

    @JoinColumn(name = "room_id")
    private Long roomId;

    public Guest(DataCreateGuest guests) {
        this.name = guests.name();
        this.cpf = guests.cpf();
        this.checkinDate = guests.checkinDate();
        this.checkoutDate = guests.checkoutDate();
        this.roomId = guests.roomId();
    }

    public void updateData(DataUpdateGuest guests) {
        if(guests.name() != null) {
            this.name = guests.name();
        }
        if(guests.cpf() != null) {
            this.cpf = guests.cpf();
        }
        if(guests.checkinDate() != null) {
            this.checkinDate = guests.checkinDate();
        }
        if(guests.checkoutDate() != null) {
            this.checkoutDate = guests.checkoutDate();
        }
    }
}
