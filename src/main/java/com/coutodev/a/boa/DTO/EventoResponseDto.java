package com.coutodev.a.boa.DTO;

import com.coutodev.a.boa.domin.TipoDoEvento;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoResponseDto {


    private Long id;
    private String nome;
    private TipoDoEvento tipo;
    private LocalDateTime data;
    private String local;
    private String descricao;
    private String organizador;
    private UUID usuarioId;


}


