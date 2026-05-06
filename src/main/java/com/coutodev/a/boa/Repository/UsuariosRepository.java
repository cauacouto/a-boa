package com.coutodev.a.boa.Repository;

import com.coutodev.a.boa.domin.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuariosRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findByEmail(String email);

    Boolean existsByEmail(String email);
}
