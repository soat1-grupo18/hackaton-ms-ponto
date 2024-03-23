package br.com.fiap.soat.pontos.entities;

import java.time.LocalDate;

public class Ponto {
    private String id;
    private String usuario;
    private String data;

    public Ponto(
            String id,
            String usuario,
            String data
    ) {
        this.id = id;
        this.usuario = usuario;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Ponto toDomain() {
        return new Ponto(id, usuario, data);
    }
}
