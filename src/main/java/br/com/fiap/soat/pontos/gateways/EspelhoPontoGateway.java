package br.com.fiap.soat.pontos.gateways;

import br.com.fiap.soat.pontos.entities.Ponto;
import br.com.fiap.soat.pontos.interfaces.gateways.EspelhoPontoGatewayPort;
import br.com.fiap.soat.pontos.interfaces.gateways.PontoGatewayPort;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EspelhoPontoGateway implements EspelhoPontoGatewayPort {

    private final PontoGatewayPort pontoGatewayPort;

    public EspelhoPontoGateway(PontoGatewayPort pontoGatewayPort) {
        this.pontoGatewayPort = pontoGatewayPort;
    }

    @Override
    public List<Ponto> obterPontosPorUsuarioEPeriodo(String usuario, LocalDate dataInicio, LocalDate dataFim) {
        List<Ponto> pontosUsuario = pontoGatewayPort.obterPontosPorUsuario(usuario, dataInicio.toString(), dataFim.toString());
        List<Ponto> pontosNoPeriodo = pontosUsuario.stream()
                .filter(ponto -> LocalDate.parse(ponto.getData()).isAfter(dataInicio.minusDays(1)) && LocalDate.parse(ponto.getData()).isBefore(dataFim.plusDays(1)))
                .collect(Collectors.toList());
        return pontosNoPeriodo;
    }
}
