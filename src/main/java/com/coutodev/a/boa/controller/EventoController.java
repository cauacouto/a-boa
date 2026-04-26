package com.coutodev.a.boa.controller;

import com.coutodev.a.boa.DTO.AtualizaçaoEvento;
import com.coutodev.a.boa.DTO.EventoResponseDto;
import com.coutodev.a.boa.DTO.EventoRequestDto;
import com.coutodev.a.boa.Service.EventoService;
import com.coutodev.a.boa.domin.Evento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {


    @Autowired
    EventoService service;

    @PostMapping()
    public ResponseEntity<EventoResponseDto> criarEvento(@RequestBody @Valid EventoRequestDto dto) {
        this.service.criarEvento(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestBody @Valid AtualizaçaoEvento dto) {
        return this.service.atualizarEvento(dto)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
    @GetMapping
    public ResponseEntity listarEventos() {
        List<EventoRequestDto> eventos = this.service.listarEventos();
        return ResponseEntity.ok(eventos);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        service.deletarEvento(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/imagem")
    public ResponseEntity<Evento> uploadImagem(@PathVariable Long id,@RequestParam("file") MultipartFile file){
        return ResponseEntity.ok(service.uploadImagem(id,file));
    }




}
