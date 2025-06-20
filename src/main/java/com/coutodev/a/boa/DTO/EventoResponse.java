package com.coutodev.a.boa.DTO;

import com.coutodev.a.boa.domin.TipoDoEvento;
import com.coutodev.a.boa.domin.evento;

import java.time.LocalDateTime;

public record EventoResponse(
        long id,
        String nome,
        TipoDoEvento tipo,
        LocalDateTime dateInitial,
        LocalDateTime dateEnd,
        String local,
        String descrição,
        String organizador
) {
 public EventoResponse(evento evento) {
        this(evento.getId(),
                evento.getNome(),
              evento.getTipo(),
                evento.getDateInitial(),
                evento.getDateEnd(),
                evento.getLocal(),
                evento.getDescrição(),
                evento.getOrganizador());
    }
}
