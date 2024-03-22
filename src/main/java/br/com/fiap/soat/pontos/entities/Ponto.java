package br.com.fiap.soat.pontos.entities;

import java.time.LocalDate;

public class Ponto {
    private String id;
    private String usuario;
    private LocalDate data;

    public Ponto(
            String id,
            String usuario,
            LocalDate data
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Ponto toDomain() {
        return new Ponto(id, usuario, data);
    }
}
