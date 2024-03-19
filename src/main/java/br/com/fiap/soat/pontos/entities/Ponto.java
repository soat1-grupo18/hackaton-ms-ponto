package br.com.fiap.soat.pontos.entities;

public class Ponto {
    private String id;
    private String usuario;
    private String data;

    public Ponto(
            String id,
            String usuario,
            String data
    ) {
        this.id = id;
        this.usuario = usuario;
        this.data = data;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getUsuario() {
        return usuario;
    }

    public void setData(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }

    public Ponto toDomain() {
        return new Ponto(
                id,
                usuario,
                data
        );
    }
}
