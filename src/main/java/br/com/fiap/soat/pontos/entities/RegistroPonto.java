package br.com.fiap.soat.pontos.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RegistroPonto {
    private String usuario;
    private LocalDate data;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaPausa;
    private LocalDateTime horaRetorno;
    private LocalDateTime horaSaida;

    public RegistroPonto(
            String usuario,
            LocalDate data,
            LocalDateTime horaEntrada,
            LocalDateTime horaPausa,
            LocalDateTime horaRetorno,
            LocalDateTime horaSaida
    ) {
        this.usuario = usuario;
        this.data = data;
        this.horaEntrada = horaEntrada;
        this.horaPausa = horaPausa;
        this.horaRetorno = horaRetorno;
        this.horaSaida = horaSaida;
    }

    private String getTotalHoras() {
        return "08:00:00";
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

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDateTime getHoraPausa() {
        return horaPausa;
    }

    public void setHoraPausa(LocalDateTime horaPausa) {
        this.horaPausa = horaPausa;
    }

    public LocalDateTime getHoraRetorno() {
        return horaRetorno;
    }

    public void setHoraRetorno(LocalDateTime horaRetorno) {
        this.horaRetorno = horaRetorno;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }
}
