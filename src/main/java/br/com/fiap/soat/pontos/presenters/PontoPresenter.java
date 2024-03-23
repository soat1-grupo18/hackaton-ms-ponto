package br.com.fiap.soat.pontos.presenters;
import br.com.fiap.soat.pontos.entities.Ponto;
import br.com.fiap.soat.pontos.entities.TipoPonto;

import java.time.LocalDate;

public class PontoPresenter {
    private String id;
    private String usuario;
    private String data;
    private String tipo;

    public PontoPresenter(String id, String usuario, String data, TipoPonto tipo) {
        this.id = id;
        this.usuario = usuario;
        this.data = data;
        this.tipo = tipo.toString();
    }

    public static PontoPresenter fromDomain(Ponto ponto) {
        return new PontoPresenter(
                ponto.getId(),
                ponto.getUsuario(),
                ponto.getData(),
                ponto.getTipo()
        );
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

    public String getTipo() {
        return tipo;
    }
}
