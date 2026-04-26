package com.coutodev.a.boa.domin;

import com.coutodev.a.boa.DTO.AtualizaçaoEvento;
import com.coutodev.a.boa.DTO.EventoResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Table(name = "evento")
@Data

@AllArgsConstructor

public class Evento {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;

    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoDoEvento tipo;

    private LocalDateTime data;

    private String local;

    private String descrição;

    private String organizador;
    @Column(name = "image_url")
    private String imageUrl;

    public Evento(EventoResponseDto dto) {

    }

    public Evento() {

    }


    public void atualizarCom(AtualizaçaoEvento dto) {
        this.nome = dto.getNome();
        this.local = dto.getLocal();
        this.data = dto.getData();
        this.descrição = dto.getDescrição();



    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoDoEvento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDoEvento tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
