package com.coutodev.a.boa.domin;

public enum Roles {
    ADMIN("admin"),
    USUARIO("usuario");


    private String role;

    Roles(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
