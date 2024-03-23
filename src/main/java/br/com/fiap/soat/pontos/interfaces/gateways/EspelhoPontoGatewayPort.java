package br.com.fiap.soat.pontos.interfaces.gateways;

import br.com.fiap.soat.pontos.entities.Ponto;

import java.time.LocalDate;
import java.util.List;

public interface EspelhoPontoGatewayPort {
    List<Ponto> obterPontosPorUsuarioEPeriodo(String usuario, LocalDate dataInicio, LocalDate dataFim);
}
