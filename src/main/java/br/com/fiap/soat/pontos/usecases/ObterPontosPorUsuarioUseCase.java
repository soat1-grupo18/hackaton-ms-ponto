package br.com.fiap.soat.pontos.usecases;

import br.com.fiap.soat.pontos.entities.Ponto;
import br.com.fiap.soat.pontos.interfaces.gateways.PontoGatewayPort;
import br.com.fiap.soat.pontos.interfaces.usecases.ObterPontosPorUsuarioUseCasePort;

import java.util.List;

public class ObterPontosPorUsuarioUseCase implements ObterPontosPorUsuarioUseCasePort {
    private final PontoGatewayPort pontoGatewayPort;

    public ObterPontosPorUsuarioUseCase(PontoGatewayPort pontoGatewayPort) {
        this.pontoGatewayPort = pontoGatewayPort;
    }

    public List<Ponto> execute(String usuario) {

        return pontoGatewayPort.obterPontosPorUsuario(usuario);
    }
}