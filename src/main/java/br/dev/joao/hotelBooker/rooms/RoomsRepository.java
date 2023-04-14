package br.dev.joao.hotelBooker.rooms;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomsRepository extends JpaRepository<Room, Long> {
    Page<Room> findAllByisAvailableTrue(Pageable paginable);

    Page<Room> findAllByisAvailableFalse(Pageable paginable);
}
