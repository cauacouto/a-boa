package com.coutodev.a.boa.domin;

public enum TipoDoEvento {

    REVEILLON("reveillon"),
    FESTIVAL("festival"),
    ELETRONICO("eletronico"),
    AFTER("after"),
    POOL_PARTY("poolparty"),
    OPEN_BAR("openbar"),
    BALADA("balada"),
    CLUBE("clube"),
    PRIVADA("privada");


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

