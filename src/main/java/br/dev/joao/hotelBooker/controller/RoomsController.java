package br.dev.joao.hotelBooker.controller;

import br.dev.joao.hotelBooker.rooms.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/rooms")
public class RoomsController {

    @Autowired
    private RoomsRepository repository;

    @GetMapping("/available")
    public ResponseEntity <Page<DataListRoom>> listAvailableRooms(@PageableDefault(size = 10, sort = {"id"})Pageable paginable) {
        var page = repository.findAllByisAvailableTrue(paginable).map(DataListRoom::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/unavailable")
    public ResponseEntity listUnavailableRooms(@PageableDefault(size =10, sort = {"id"}) Pageable paginable) {
        var page = repository.findAllByisAvailableFalse(paginable).map(DataListRoom::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity listOneRoom(@PathVariable Long id) {
        var room = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataDetailRoom(room));
    }



    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DataCreateRoom rooms, UriComponentsBuilder uriComponentsBuilder) {
        var room = new Room(rooms);
        repository.save(room);
        var uri = uriComponentsBuilder.path("/rooms/{id}").buildAndExpand(room.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailRoom(room));
    }

    @DeleteMapping("/unavailable/{id}")
    @Transactional
    public ResponseEntity setRoomNotAvailable(@PathVariable Long id) {
        var room = repository.getReferenceById(id);
        room.IsNotAvailable();

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/available/{id}")
    @Transactional
    public ResponseEntity setRoomAvailable(@PathVariable Long id) {
        var room = repository.getReferenceById(id);
        room.isAvailable();

        return ResponseEntity.ok(new DataDetailRoom(room));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateRoom(@RequestBody @Valid DataUpdateRoom rooms) {
        var room = repository.getReferenceById(rooms.id());
        room.updateData(rooms);

        return ResponseEntity.ok(new DataDetailRoom(room));
    }


}

