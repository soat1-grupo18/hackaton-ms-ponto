package br.com.fiap.soat.pontos.interfaces.gateways;

import br.com.fiap.soat.pontos.entities.Ponto;

import java.util.List;

public interface PontoGatewayPort {
    List<Ponto> obterPontosPorUsuario(String usuario, String dataInicial, String dataFinal);
    Ponto criarPonto(Ponto ponto);

}
