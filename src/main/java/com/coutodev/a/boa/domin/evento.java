package com.coutodev.a.boa.domin;

import com.coutodev.a.boa.DTO.AtualizaçaoEvento;
import com.coutodev.a.boa.DTO.EventoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public evento (EventoRequest dto) {
        this.nome = dto.nome();
        this.tipo = dto.tipo();
        this.dateInitial = dto.dateInitial();
        this.dateEnd = dto.dateEnd();
        this.local = dto.local();
        this.descrição = dto.descrição();
        this.organizador = dto.organizador();
    }


    public evento(){}
}
