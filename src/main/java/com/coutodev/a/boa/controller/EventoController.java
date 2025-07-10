package com.coutodev.a.boa.controller;

import com.coutodev.a.boa.DTO.AtualizaçaoEvento;
import com.coutodev.a.boa.DTO.EventoRequest;
import com.coutodev.a.boa.DTO.EventoResponse;
import com.coutodev.a.boa.Service.EventoServise;
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
    EventoServise eventoServise;

    @PostMapping
    public ResponseEntity criarEvento(@RequestBody @Valid EventoRequest dto) {
        this.eventoServise.criarEvento(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid AtualizaçaoEvento dto) {
        return this.eventoServise.atualizarEvento(dto)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
    @GetMapping
    public ResponseEntity listarEventos() {
        List<EventoResponse> eventos = this.eventoServise.listarEventos();
        return ResponseEntity.ok(eventos);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        eventoServise.deletarEvento(id);
        return ResponseEntity.noContent().build();
    }




}
