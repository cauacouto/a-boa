package com.coutodev.a.boa.DTO;

import com.coutodev.a.boa.domin.Roles;
import com.coutodev.a.boa.domin.Usuario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.UUID;

@Data

public class DadosCadastroResponse {
    private UUID id;
    private String nome;
    private String email;
   private Roles role;


    public DadosCadastroResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.role = usuario.getRoles();
    }

    public DadosCadastroResponse() {}
}
