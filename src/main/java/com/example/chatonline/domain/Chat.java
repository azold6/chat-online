package com.example.chatonline.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Chat implements Serializable {
    private static final Long serialVersionUID = 1L;

    private Integer id;

    //implementar - lista de usuarios logados
    //implementar - mensagens

    public Chat() {
    }

    public Chat(Integer id, String texto, Date dataEnvio) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return Objects.equals(id, chat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
