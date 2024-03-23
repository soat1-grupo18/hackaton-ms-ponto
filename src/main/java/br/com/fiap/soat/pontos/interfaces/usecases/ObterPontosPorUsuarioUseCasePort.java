package br.com.fiap.soat.pontos.interfaces.usecases;

import br.com.fiap.soat.pontos.entities.Ponto;

import java.util.List;

public interface ObterPontosPorUsuarioUseCasePort {
     List<Ponto> execute(String usuario, String dataInicial, String dataFinal);
}