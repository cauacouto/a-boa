package com.coutodev.a.boa.controller;

import com.coutodev.a.boa.DTO.AtualizaçaoEvento;
import com.coutodev.a.boa.DTO.EventoRequest;
import com.coutodev.a.boa.DTO.EventoResponse;
import com.coutodev.a.boa.Service.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventoController {


    @Autowired
    EventoService service;

    @PostMapping("/criarEvento")
    public ResponseEntity criarEvento(@RequestBody @Valid EventoRequest dto) {
        this.service.criarEvento(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid AtualizaçaoEvento dto) {
        return this.service.atualizarEvento(dto)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
    @GetMapping
    public ResponseEntity listarEventos() {
        List<EventoResponse> eventos = this.service.listarEventos();
        return ResponseEntity.ok(eventos);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        service.deletarEvento(id);
        return ResponseEntity.noContent().build();
    }




}
