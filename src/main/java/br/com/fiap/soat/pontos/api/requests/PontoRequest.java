package br.com.fiap.soat.pontos.api.requests;

import br.com.fiap.soat.pontos.entities.Ponto;

import java.time.Instant;
import java.time.LocalDate;

public class PontoRequest {
    private String id;
    private String usuario;
    private String data;

    Instant currentInstant = Instant.now();

    public Ponto toDomain() {
        Ponto ponto = new Ponto(null, usuario, data);
        return ponto;
    }

    public String getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getData() {
        return data;
    }
}
