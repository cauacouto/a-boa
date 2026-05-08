package com.coutodev.a.boa.DTO;

import com.coutodev.a.boa.domin.Evento;
import com.coutodev.a.boa.domin.TipoDoEvento;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data

public class EventoResponseDto {


    private Long id;
    private String nome;
    private TipoDoEvento tipo;
    private LocalDateTime data;
    private String local;
    private String descricao;
    private String organizador;
    private UUID usuarioId;
    private String imageUrl;


    public EventoResponseDto(){}

    public EventoResponseDto(Evento evento) {
        this.id = evento.getId();
        this.nome = evento.getNome();
        this.tipo = evento.getTipo();
        this.data = evento.getData();
        this.local = evento.getLocal();
        this.descricao = evento.getDescricao();
        this.organizador = evento.getOrganizador();
        this.usuarioId = evento.getUsuario().getId();
        this.imageUrl = evento.getImageUrl();
    }
}


