package com.coutodev.a.boa.Service;

import com.coutodev.a.boa.DTO.EventoRequestDto;
import com.coutodev.a.boa.DTO.EventoResponseDto;
import com.coutodev.a.boa.Repository.EventoRpository;
import com.coutodev.a.boa.domin.Evento;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
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
    private final long tamanhoMaximo = 5 * 1024 * 1024; // 5MB

    private final ModelMapper mapper;

    public EventoService(EventoRpository eventoRepository, ModelMapper mapper) {
        this.eventoRepository = eventoRepository;
        this.mapper = mapper;
    }

    public EventoResponseDto criarEvento(EventoRequestDto dto) {
        Evento evento = mapper.map(dto, Evento.class);
        var salvo = eventoRepository.save(evento);
        return mapper.map(salvo,EventoResponseDto.class);
    }

    public EventoResponseDto atualizarEvento(EventoRequestDto dto,Long id,UserDetails usuarioLogado) {
        var evento = eventoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("evento não encontrado"));
        mapper.map(dto,evento);
        var salvo =  eventoRepository.save(evento);
        return mapper.map(salvo, EventoResponseDto.class);

    }

    public List<EventoResponseDto> listarEventos() {
        return eventoRepository.findAll()
                .stream()
                .map(Evento-> mapper.map(Evento, EventoResponseDto.class))
                .toList();
    }

    public void deletarEvento(Long id, UserDetails usuarioLogado) {
        var evento = eventoRepository.findById(id)
                        .orElseThrow(()-> new RuntimeException("evento não encontrado"));

        if (!evento.getUsuario().getEmail().equals(usuarioLogado.getUsername())){
            throw new RuntimeException("voce não tem permissao para dletar esse evento");
        }

        eventoRepository.deleteById(id);
    }

    public EventoResponseDto buscarPorId(Long id) {
        return eventoRepository.findById(id)
                .map(Evento-> mapper.map(Evento, EventoResponseDto.class))
                .orElseThrow(()-> new RuntimeException("evento não encontrado"));
    }

    public Evento uploadImagem(Long id, MultipartFile file,UserDetails usuarioLogado){
        if (!tiposPermitidos.contains(file.getContentType())){
            throw new RuntimeException("apenas imagens são permitidas");
        }
        if (file.getSize() > tamanhoMaximo){
            throw new RuntimeException("imagem deve ter no minimo 5mb");
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

