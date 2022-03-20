package com.example.chatonline.domain.enums;

public enum Perfil {

    ADMIN(1, "ROLE_ADMIN"),
    USUARIO(2, "ROLE_USUARIO");

    private int cod;
    private String description;

    Perfil(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    //return object - enum(convert Integer to enum)
    public static Perfil toEnum(Integer cod){

        if(cod == null) return null;

        for (Perfil ct : Perfil.values()) {
            if(cod.equals(ct.getCod()))
                return ct;
        }
        throw new IllegalArgumentException("Invalid id " + cod);
    }
}
