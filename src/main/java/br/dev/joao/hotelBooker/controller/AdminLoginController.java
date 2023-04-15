package br.dev.joao.hotelBooker.controller;

import br.dev.joao.hotelBooker.admin.Admin;
import br.dev.joao.hotelBooker.admin.DataAuthentication;
import br.dev.joao.hotelBooker.security.DataTokenJWT;
import br.dev.joao.hotelBooker.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AdminLoginController {
    @Autowired
    AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DataAuthentication data) {
        var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = manager.authenticate(token);

        var tokenJWT = tokenService.generateToken((Admin) authentication.getPrincipal());

        return ResponseEntity.ok(new DataTokenJWT(tokenJWT));
    }
}
