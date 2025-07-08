package com.coutodev.a.boa.controller;

import com.coutodev.a.boa.DTO.AtualizaçaoEvento;
import com.coutodev.a.boa.DTO.EventoRequest;
import com.coutodev.a.boa.DTO.EventoResponse;
import com.coutodev.a.boa.Repository.EventoRpository;
import com.coutodev.a.boa.domin.evento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    EventoRpository eventoRpository;


    @PostMapping
    public ResponseEntity criarEvento(@RequestBody @Valid EventoRequest dto) {
        evento newevento = new evento(dto);
        this.eventoRpository.save(newevento);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid AtualizaçaoEvento dto){
        try {
            var eventoOpt = this.eventoRpository.findById(dto.id());
            if (eventoOpt.isEmpty()) return ResponseEntity.notFound().build();

            this.eventoRpository.save(eventoOpt.get());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar o evento: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity listarEventos() {

        List<EventoResponse> eventos = this.eventoRpository.findAll().stream()
                .map(EventoResponse::new)
                .toList();
        return ResponseEntity.ok(eventos);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar (@PathVariable Long id){
        eventoRpository.deleteById(id);
        return ResponseEntity.noContent().build();
    }




}
