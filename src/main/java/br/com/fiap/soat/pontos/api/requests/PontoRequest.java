package br.com.fiap.soat.pontos.api.requests;

import br.com.fiap.soat.pontos.entities.Ponto;
import br.com.fiap.soat.pontos.entities.TipoPonto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PontoRequest {
    private String usuario;
    private String data;
    private String tipo;

    public Ponto toDomain() {
        String dataHora = data;
        if (dataHora == null || dataHora.isEmpty())
            dataHora = LocalDateTime.now().toString();
        if (!isValidTimestamp(dataHora)) {
            throw new IllegalArgumentException("A data informada não está no formato ISO (YYYY-MM-DDTHH:MM:SS).");
        }
        return new Ponto(null, usuario, dataHora, TipoPonto.valueOf(tipo));
    }

    private boolean isValidTimestamp(String timestamp) {
        try {
            LocalDateTime.parse(timestamp, DateTimeFormatter.ISO_DATE_TIME);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
