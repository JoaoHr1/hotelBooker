package br.dev.joao.hotelBooker.controller;

import br.dev.joao.hotelBooker.guests.*;
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
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestRepository repository;

    @GetMapping
    public ResponseEntity<Page<DataListGuest>> listGuests(@PageableDefault(size = 10, sort = {"id"})Pageable paginable) {
        var page = repository.findAll(paginable).map(DataListGuest::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity listOneGuest(@PathVariable Long id) {
        var guest = repository.getReferenceById(id);

        return ResponseEntity.ok(new DataDetailGuest(guest));
    }

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DataCreateGuest guests, UriComponentsBuilder uriComponentsBuilder) {
        var guest = new Guest(guests);
        repository.save(guest);
        var uri = uriComponentsBuilder.path("/guests/{id}").buildAndExpand(guest.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailGuest(guest));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteGuest(@PathVariable Long id) {
        var guest = repository.getReferenceById(id);
        repository.delete(guest);

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateGuest(@RequestBody @Valid DataUpdateGuest guests) {
        var guest = repository.getReferenceById(guests.id());
        guest.updateData(guests);

        return ResponseEntity.ok(new DataDetailGuest(guest));
    }
}
