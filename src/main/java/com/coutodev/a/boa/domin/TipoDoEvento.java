package com.coutodev.a.boa.domin;

public enum TipoDoEvento {

    SHOW,
    FESTIVAL,
    SAMBA,
    PAGODE,
    AFTER,
    CULTURAL,
    ESPORTIVO,
    GASTRONOMICO("gastronômico"),
    FEIRA,
    OUTROS;


    private String descricao;

    TipoDoEvento() {
        this.descricao = this.name();
    }

    TipoDoEvento(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

}

