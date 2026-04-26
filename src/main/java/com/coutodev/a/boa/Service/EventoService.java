package com.coutodev.a.boa.Service;

import com.coutodev.a.boa.DTO.AtualizaçaoEvento;
import com.coutodev.a.boa.DTO.EventoRequestDto;
import com.coutodev.a.boa.DTO.EventoResponseDto;
import com.coutodev.a.boa.Repository.EventoRpository;
import com.coutodev.a.boa.domin.Evento;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class EventoService {


    private final EventoRpository eventoRepository;

    private final String uploadDir = "uploads/eventos/";
    private final List<String> tiposPermitidos = List.of("image/jpeg","image/png","image/webp");

    private final ModelMapper mapper;

    public EventoService(EventoRpository eventoRepository, ModelMapper mapper) {
        this.eventoRepository = eventoRepository;
        this.mapper = mapper;
    }

    public EventoResponseDto criarEvento(EventoRequestDto dto) {
        Evento evento = mapper.map(dto, Evento.class);
        evento = eventoRepository.save(evento);
        return mapper.map(evento,EventoResponseDto.class);
    }

    public boolean atualizarEvento(AtualizaçaoEvento dto) {
        var eventoOpt = eventoRepository.findById(dto.getId());
        if (eventoOpt.isEmpty()) return false;

        var evento = eventoOpt.get();
        evento.atualizarCom(dto);
        eventoRepository.save(evento);
        return true;
    }

    public List<EventoRequestDto> listarEventos() {
        return eventoRepository.findAll()
                .stream()
                .map(EventoRequestDto::new)
                .toList();
    }

    public void deletarEvento(Long id) {
        eventoRepository.deleteById(id);
    }

    public EventoRequestDto buscarPorId(Long id) {
        return eventoRepository.findById(id)
                .map(EventoRequestDto::new)
                .orElse(null);
    }

    public Evento uploadImagem(Long id, MultipartFile file){
        if (!tiposPermitidos.contains(file.getContentType())){
            throw new RuntimeException("apenas imagens são permitidas");
        }
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("evento não encontrado"));

        try {
            String nomeArquivo = id + "-" + UUID.randomUUID() + "-" + file.getOriginalFilename();
            Path path = Paths.get(uploadDir + nomeArquivo);
            Files.createDirectories(path.getParent());
            Files.write(path,file.getBytes());

            evento.setImageUrl("uploads/eventos/" + nomeArquivo);
            return eventoRepository.save(evento);
        }catch (IOException e){
            throw  new RuntimeException("erro ao salvar imagem ", e);
        }
    }

}

