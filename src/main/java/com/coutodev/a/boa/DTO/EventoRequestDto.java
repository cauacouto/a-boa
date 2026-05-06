package com.coutodev.a.boa.DTO;

import com.coutodev.a.boa.domin.TipoDoEvento;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoRequestDto {
    private String nome;
    private TipoDoEvento tipo;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime data;
    private String local;
    private String descricao;
    private String organizador;
}