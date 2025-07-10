package com.coutodev.a.boa.Service;

import com.coutodev.a.boa.DTO.AtualizaçaoEvento;
import com.coutodev.a.boa.DTO.EventoRequest;
import com.coutodev.a.boa.DTO.EventoResponse;
import com.coutodev.a.boa.Repository.EventoRpository;
import com.coutodev.a.boa.domin.evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServise {

    @Autowired
    EventoRpository eventoRpository;

    public void criarEvento(EventoRequest dto) {
        evento newevento = new evento(dto);
        this.eventoRpository.save(newevento);
    }

    public boolean atualizarEvento(AtualizaçaoEvento dto) {
        var eventoOpt = eventoRpository.findById(dto.id());
        if (eventoOpt.isEmpty()) return false;
        var evento = eventoOpt.get();
        evento.atualizarCom(dto);
        eventoRpository.save(evento);
        return true;
    }
    public List<EventoResponse> listarEventos() {
        return eventoRpository.findAll().stream()
                .map(EventoResponse::new)
                .toList();
    }

    public void deletarEvento(Long id) {
        eventoRpository.deleteById(id);
    }
}

