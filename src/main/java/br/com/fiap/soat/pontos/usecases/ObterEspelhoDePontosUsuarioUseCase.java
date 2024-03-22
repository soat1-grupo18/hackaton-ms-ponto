package br.com.fiap.soat.pontos.usecases;

import br.com.fiap.soat.pontos.entities.Ponto;
import br.com.fiap.soat.pontos.interfaces.gateways.PontoGatewayPort;
import br.com.fiap.soat.pontos.interfaces.usecases.ObterEspelhoDePontosUsuarioUseCasePort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObterEspelhoDePontosUsuarioUseCase implements ObterEspelhoDePontosUsuarioUseCasePort {
    private final PontoGatewayPort pontoGatewayPort;

    public ObterEspelhoDePontosUsuarioUseCase(PontoGatewayPort pontoGatewayPort) {
        this.pontoGatewayPort = pontoGatewayPort;
    }

    @Override
    public List<Ponto> obterEspelhoDePontosPorUsuarioEPeriodo(String usuario, LocalDate dataInicio, LocalDate dataFim) {
        List<Ponto> pontosUsuario = pontoGatewayPort.obterPontosPorUsuario(usuario);
        List<Ponto> pontosNoPeriodo = pontosUsuario.stream()
                .filter(ponto -> ponto.getData().isAfter(dataInicio.minusDays(1)) && ponto.getData().isBefore(dataFim.plusDays(1)))
                .collect(Collectors.toList());
        return pontosNoPeriodo;
    }
}
