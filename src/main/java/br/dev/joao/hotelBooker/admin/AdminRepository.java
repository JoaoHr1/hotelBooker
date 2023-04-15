package br.dev.joao.hotelBooker.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    UserDetails findByLogin(String login);
}
