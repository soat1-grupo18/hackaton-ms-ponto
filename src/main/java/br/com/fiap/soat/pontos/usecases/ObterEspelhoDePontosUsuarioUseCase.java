package br.com.fiap.soat.pontos.usecases;

import br.com.fiap.soat.pontos.entities.Ponto;
import br.com.fiap.soat.pontos.interfaces.gateways.PontoGatewayPort;
import br.com.fiap.soat.pontos.interfaces.usecases.ObterEspelhoDePontosUsuarioUseCasePort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObterEspelhoDePontosUsuarioUseCase implements ObterEspelhoDePontosUsuarioUseCasePort {
    private final PontoGatewayPort pontoGatewayPort;

    public ObterEspelhoDePontosUsuarioUseCase(PontoGatewayPort pontoGatewayPort) {
        this.pontoGatewayPort = pontoGatewayPort;
    }

    @Override
    public List<Ponto> obterEspelhoDePontosPorUsuarioEPeriodo(String usuario, LocalDateTime dataInicio, LocalDateTime dataFim) {
        List<Ponto> pontosUsuario = pontoGatewayPort.obterPontosPorUsuario(usuario, dataInicio.toString(), dataFim.toString());
        return pontosUsuario.stream().collect(Collectors.toList());
    }
}
