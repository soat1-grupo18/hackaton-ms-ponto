package br.com.fiap.soat.pontos.interfaces.gateways;

import br.com.fiap.soat.pontos.entities.Ponto;

import java.util.List;

public interface PontoGatewayPort {
    List<Ponto> obterPontosPorUsuario(String usuario);
    Ponto criarPonto(Ponto ponto);

}
