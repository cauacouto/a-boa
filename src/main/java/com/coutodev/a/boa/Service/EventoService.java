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
public class EventoService {

    @Autowired
    private EventoRpository eventoRepository;

    public EventoService(EventoRpository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public void criarEvento(EventoRequest dto) {
        evento novoEvento = new evento(dto);
        this.eventoRepository.save(novoEvento);
    }

    public boolean atualizarEvento(AtualizaçaoEvento dto) {
        var eventoOpt = eventoRepository.findById(dto.getId());
        if (eventoOpt.isEmpty()) return false;

        var evento = eventoOpt.get();
        evento.atualizarCom(dto);
        eventoRepository.save(evento);
        return true;
    }

    public List<EventoResponse> listarEventos() {
        return eventoRepository.findAll()
                .stream()
                .map(EventoResponse::new)
                .toList();
    }

    public void deletarEvento(Long id) {
        eventoRepository.deleteById(id);
    }

    public EventoResponse buscarPorId(Long id) {
        return eventoRepository.findById(id)
                .map(EventoResponse::new)
                .orElse(null);
    }
}

