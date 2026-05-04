package com.coutodev.a.boa.controller;

import com.coutodev.a.boa.DTO.DadosCadastroDto;
import com.coutodev.a.boa.DTO.DadosTokenJWT;
import com.coutodev.a.boa.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<Void> register(@RequestBody DadosCadastroDto dados ){
        usuarioService.registrar(dados);
        return ResponseEntity.ok().build();
    }
    @PostMapping
    public ResponseEntity login(@RequestBody DadosCadastroDto dto){
        var token = usuarioService.login(dto);
        return ResponseEntity.ok(new DadosTokenJWT(token));
    }
}
