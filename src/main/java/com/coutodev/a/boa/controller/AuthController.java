package com.coutodev.a.boa.controller;

import com.coutodev.a.boa.DTO.DadosCadastroDto;
import com.coutodev.a.boa.DTO.DadosCadastroResponse;
import com.coutodev.a.boa.DTO.DadosLoginDto;
import com.coutodev.a.boa.DTO.DadosTokenJWT;
import com.coutodev.a.boa.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @PostMapping("/register")
    public ResponseEntity<DadosCadastroResponse> register(@RequestBody DadosCadastroDto dados ){
       DadosCadastroResponse response = usuarioService.registrar(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PostMapping("/login")
    public ResponseEntity<DadosTokenJWT> login(@RequestBody DadosLoginDto dto){
        var token = usuarioService.login(dto);
        return ResponseEntity.ok(new DadosTokenJWT(token));
    }
}
