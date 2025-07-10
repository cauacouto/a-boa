package com.coutodev.a.boa.domin;

import com.coutodev.a.boa.DTO.AtualizaçaoEvento;
import com.coutodev.a.boa.DTO.EventoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Table(name = "evento")
@Data

@AllArgsConstructor

public class evento {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;

    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoDoEvento tipo;

    private LocalDateTime dateInitial;
    private  LocalDateTime dateEnd;

    private String local;

    private String descrição;

    private String organizador;

    public TipoDoEvento getTipo() {
        return tipo;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getDateInitial() {
        return dateInitial;
    }
    public LocalDateTime getDateEnd() {
        return dateEnd;
    }
    public String getLocal() {
        return local;
    }

    public String getDescrição() {
        return descrição;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(TipoDoEvento tipo) {
        this.tipo = tipo;
    }

    public void setDateInitial(LocalDateTime dateInitial) {
        this.dateInitial = dateInitial;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public evento (EventoRequest dto) {
        this.nome = dto.nome();
        this.tipo = dto.tipo();
        this.dateInitial = dto.dateInitial();
        this.dateEnd = dto.dateEnd();
        this.local = dto.local();
        this.descrição = dto.descrição();
        this.organizador = dto.organizador();
    }

    public void atualizarCom(AtualizaçaoEvento dto) {
        setNome(dto.nome());
        setTipo(dto.tipo());
        setDateInitial(dto.dateInitial());
        setDateEnd(dto.dateEnd());
        setLocal(dto.local());
        setDescrição(dto.descrição());
        setOrganizador(dto.organizador());
    }


    public evento(){}
}
