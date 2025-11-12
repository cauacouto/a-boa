package com.coutodev.a.boa.controller;

import com.coutodev.a.boa.DTO.AtualizaçaoEvento;
import com.coutodev.a.boa.DTO.EventoRequest;
import com.coutodev.a.boa.DTO.EventoResponse;
import com.coutodev.a.boa.Service.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/eventos")
public class EventoViewController {

    @Autowired
    private EventoService service;

    // Página: lista todos os eventos
    @GetMapping
    public String listarEventos(org.springframework.ui.Model model) {
        List<EventoResponse> eventos = service.listarEventos();
        model.addAttribute("eventos", eventos);
        return "event-list"; // templates/event-list.html
    }

    // Página: formulário de criação
    @GetMapping("/novo")
    public String novoEvento(org.springframework.ui.Model model) {
        model.addAttribute("evento", new EventoRequest());
        return "event-form";
    }

    // Criar evento (POST /eventos)
    @PostMapping
    public String criarEvento(@ModelAttribute("evento") @Valid EventoRequest dto) {
        service.criarEvento(dto);
        return "redirect:/eventos";
    }

    // Página: formulário de edição
    @GetMapping("/editar/{id}")
    public String editarEvento(@PathVariable Long id, Model model) {
        EventoResponse evento = service.buscarPorId(id);
        if (evento == null) {
            return "redirect:/eventos";
        }
        AtualizaçaoEvento dto = new AtualizaçaoEvento();
        dto.setId(evento.id());
        dto.setNome(evento.nome());
        dto.setLocal(evento.local());
        dto.setData(evento.data());
        dto.setDescrição(evento.descrição());
        model.addAttribute("evento", dto);
        return "event-form";
    }

    // Atualizar evento (PUT via hidden input)
    @PostMapping(value = "/{id}", params = "_method=put")
    public String atualizarEvento(@PathVariable Long id, @ModelAttribute("evento") @Valid AtualizaçaoEvento dto) {
        dto.setId(id);
        AtualizaçaoEvento dto1 = dto;
        return "redirect:/eventos";
    }

    // Excluir evento
    @PostMapping(value = "/{id}", params = "_method=delete")
    public String deletarEvento(@PathVariable Long id) {
       service.deletarEvento(id);
        return "redirect:/eventos";
    }
}

