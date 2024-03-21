package br.com.fiap.soat.pontos.api.requests;

import br.com.fiap.soat.pontos.entities.Ponto;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class PontoRequest {
    private String id;
    private String usuario;

    Instant currentInstant = Instant.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    String data = formatter.format(currentInstant.atOffset(ZoneOffset.UTC));

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
