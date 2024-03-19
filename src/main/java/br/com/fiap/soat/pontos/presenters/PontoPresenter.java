package br.com.fiap.soat.pontos.presenters;
import br.com.fiap.soat.pontos.entities.Ponto;

public class PontoPresenter {
    private String id;
    private String usuario;
    private String data;

    public PontoPresenter(String id, String usuario, String data) {
        this.id = id;
        this.usuario = usuario;
        this.data = data;
    }

    public static PontoPresenter fromDomain(Ponto ponto) {
        return new PontoPresenter(
                ponto.getId(),
                ponto.getUsuario(),
                ponto.getData(),
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
}
