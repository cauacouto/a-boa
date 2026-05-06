package com.coutodev.a.boa.controller;

import com.coutodev.a.boa.DTO.EventoResponseDto;
import com.coutodev.a.boa.DTO.EventoRequestDto;
import com.coutodev.a.boa.Service.EventoService;
import com.coutodev.a.boa.domin.Evento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
    public ResponseEntity<EventoResponseDto> criarEvento(@RequestBody @Valid EventoRequestDto dto,@AuthenticationPrincipal UserDetails usuarioLogado) {
        EventoResponseDto response = service.criarEvento(dto,usuarioLogado);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<EventoResponseDto> atualizar(@RequestBody @Valid EventoRequestDto dto,Long id,@AuthenticationPrincipal UserDetails usuarioLogado) {
     EventoResponseDto response = service.atualizarEvento(dto,id,usuarioLogado);
     return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity listarEventos() {
        List<EventoResponseDto> eventos = this.service.listarEventos();
        return ResponseEntity.ok(eventos);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id, @AuthenticationPrincipal UserDetails usuarioLogado) {
        service.deletarEvento(id,usuarioLogado);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoResponseDto> buscarPorId(@PathVariable Long id){
      EventoResponseDto buscar = service.buscarPorId(id);
      return ResponseEntity.ok(buscar);
    }

    @PostMapping("/{id}/imagem")
    public ResponseEntity<Evento> uploadImagem(@PathVariable Long id,@RequestParam("file") MultipartFile file,@AuthenticationPrincipal UserDetails usuarioLogado){
        return ResponseEntity.ok(service.uploadImagem(id,file,usuarioLogado));
    }




}
