package com.coutodev.a.boa.domin;

public enum TipoDoEvento {

    SHOW("show"),
    FESTIVAL("festival"),
    SAMBA("samba"),
    PAGODE("pagode"),
    AFTER("after"),
    CULTURAL("cultural"),
    ESPORTIVO("esportivo"),
    GASTRONOMICO("gastronômico"),
    FEIRA("feira"),
    OUTROS("outros");


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

