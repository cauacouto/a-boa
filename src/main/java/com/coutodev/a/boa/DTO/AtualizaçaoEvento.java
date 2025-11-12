package com.coutodev.a.boa.DTO;

import com.coutodev.a.boa.domin.TipoDoEvento;

import java.time.LocalDateTime;

public class AtualizaçaoEvento{ private String nome;

                                private  Long id;
                               private TipoDoEvento tipo;
                              private LocalDateTime data;

                                private   String local;
                              private    String descrição;
                               private   String organizador;

                               public AtualizaçaoEvento(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setData(LocalDateTime dateInitial) {
        this.data = dateInitial;
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
}
