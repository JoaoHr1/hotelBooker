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

    @GetMapping
    public ResponseEntity <Page<DataListRoom>> list(@PageableDefault(size = 10, sort = {"id"})Pageable paginable) {
        var page = repository.findAllByisAvailableTrue(paginable).map(DataListRoom::new);

        return ResponseEntity.ok(page);
    }

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DataCreateRoom rooms, UriComponentsBuilder uriComponentsBuilder) {
        var room = new Room(rooms);
        repository.save(room);
        var uri = uriComponentsBuilder.path("/rooms/{id}").buildAndExpand(room.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailRoom(room));
    }
}
