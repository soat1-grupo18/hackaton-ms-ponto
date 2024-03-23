package br.com.fiap.soat.pontos.interfaces.usecases;

import br.com.fiap.soat.pontos.entities.Ponto;

import java.time.LocalDateTime;
import java.util.List;

public interface ObterEspelhoDePontosUsuarioUseCasePort {
    List<Ponto> obterEspelhoDePontosPorUsuarioEPeriodo(String usuario, LocalDateTime dataInicio, LocalDateTime dataFim);
}
