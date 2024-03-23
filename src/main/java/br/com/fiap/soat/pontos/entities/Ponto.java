package br.com.fiap.soat.pontos.entities;

import java.time.LocalDate;

public class Ponto {
    private String id;
    private String usuario;
    private String data;
    private TipoPonto tipo;

    public Ponto(
            String id,
            String usuario,
            String data,
            TipoPonto tipo
    ) {
        this.id = id;
        this.usuario = usuario;
        this.data = data;
        this.tipo = tipo;
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

    public TipoPonto getTipo() {
        return tipo;
    }

    public void setTipo(TipoPonto tipo) {
        this.tipo = tipo;
    }
}
