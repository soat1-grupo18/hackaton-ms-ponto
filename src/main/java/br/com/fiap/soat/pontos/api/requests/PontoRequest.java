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

        LocalDate localDate = LocalDate.parse(data);
        Ponto ponto = new Ponto(null, usuario, localDate);

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
