package com.coutodev.a.boa.Service;

import com.coutodev.a.boa.DTO.DadosCadastroDto;
import com.coutodev.a.boa.DTO.DadosCadastroResponse;
import com.coutodev.a.boa.DTO.DadosLoginDto;
import com.coutodev.a.boa.Exception.UsuarioExcepiton;
import com.coutodev.a.boa.Repository.UsuariosRepository;
import com.coutodev.a.boa.Security.TokenService;
import com.coutodev.a.boa.domin.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuariosRepository usuariosRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;



    public DadosCadastroResponse registrar(DadosCadastroDto dados){
         if (usuariosRepository.existsByEmail(dados.getEmail())){
         throw new RuntimeException("email ja existente");

         }

         var senhaCriptografada = passwordEncoder.encode(dados.getPassword());
         Usuario usuario = new Usuario(dados,senhaCriptografada);
             usuariosRepository.save(usuario);
            return new DadosCadastroResponse(usuario);

    }

    public String login(DadosLoginDto dados){
        var usuario = usuariosRepository.findByEmail(dados.getEmail())
                .orElseThrow(UsuarioExcepiton::new);


        if (!passwordEncoder.matches(dados.getPassword(), usuario.getPassword())){
            throw new RuntimeException("senha invalida");
        }
        return tokenService.gerarToken(usuario);
    }




}
