package com.coutodev.a.boa.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.coutodev.a.boa.DTO.EventoRequestDto;
import com.coutodev.a.boa.DTO.EventoResponseDto;
import com.coutodev.a.boa.Repository.EventoRpository;
import com.coutodev.a.boa.domin.Evento;
import com.coutodev.a.boa.domin.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class EventoService {


    private final EventoRpository eventoRepository;

    @Autowired
    private Cloudinary cloudinary;



    private final String uploadDir = "uploads/eventos/";
    private final List<String> tiposPermitidos = List.of("image/jpeg","image/png","image/webp");
    private final long tamanhoMaximo = 5 * 1024 * 1024; // 5MB

    private final ModelMapper mapper;

    public EventoService(EventoRpository eventoRepository,  ModelMapper mapper) {
        this.eventoRepository = eventoRepository;


        this.mapper = mapper;
    }

    public EventoResponseDto criarEvento(EventoRequestDto dto,UserDetails usuarioLogado) {
        Evento evento = mapper.map(dto, Evento.class);
        Usuario usuario =(Usuario) usuarioLogado;
        evento.setUsuario(usuario);
        var salvo = eventoRepository.save(evento);
       EventoResponseDto response = mapper.map(salvo, EventoResponseDto.class);
       response.setUsuarioId(usuario.getId());
       return response;
    }

    public EventoResponseDto atualizarEvento(EventoRequestDto dto,Long id,UserDetails usuarioLogado) {
        var evento = eventoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("evento não encontrado"));


        if (!evento.getUsuario().getEmail().equals(usuarioLogado.getUsername())){
            throw new RuntimeException("voce não tem permissao para atualizar esse evento");
        }

        Usuario usuario = (Usuario) usuarioLogado;
        mapper.map(dto,evento);
        evento.setUsuario(usuario);

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
            throw new RuntimeException("voce não tem permissao para deletar esse evento");
        }

        eventoRepository.deleteById(id);
    }

    public EventoResponseDto buscarPorId(Long id) {
        return eventoRepository.findById(id)
                .map(Evento-> mapper.map(Evento, EventoResponseDto.class))
                .orElseThrow(()-> new RuntimeException("evento não encontrado"));
    }

    public EventoResponseDto uploadImagem(Long id, MultipartFile file, UserDetails usuarioLogado) {

        if (!tiposPermitidos.contains(file.getContentType())) {
            throw new RuntimeException("Apenas imagens são permitidas");
        }

        if (file.getSize() > tamanhoMaximo) {
            throw new RuntimeException("Imagem muito grande");
        }



        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));

        try {

            Map uploadResult = cloudinary.uploader().upload(
                    file.getBytes(),
                    ObjectUtils.asMap(
                            "folder", "a-boa/eventos"
                    )
            );

            String imageUrl = uploadResult.get("secure_url").toString();

            evento.setImageUrl(imageUrl);

           eventoRepository.save(evento);
           return new EventoResponseDto(evento);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar imagem para Cloudinary", e);
        }
    }

}

