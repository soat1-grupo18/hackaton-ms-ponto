package br.com.fiap.soat.pontos.api.requests;

import br.com.fiap.soat.pontos.entities.Ponto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PontoRequest {
    private String usuario;
    private String data;

    public Ponto toDomain() {
        String dataHora = data;
        if (dataHora == null || dataHora.isEmpty())
            dataHora = LocalDateTime.now().toString();
        if (!isValidTimestamp(dataHora)) {
            throw new IllegalArgumentException("A data informada não está no formato ISO (YYYY-MM-DDTHH:MM:SS).");
        }
        return new Ponto(null, usuario, dataHora);
    }

    public String getUsuario() {
        return usuario;
    }

    public String getData() {
        return data;
    }

    private boolean isValidTimestamp(String timestamp) {
        try {
            LocalDateTime.parse(timestamp, DateTimeFormatter.ISO_DATE_TIME);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
