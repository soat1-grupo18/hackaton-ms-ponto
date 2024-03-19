package br.com.fiap.soat.pontos.usecases;

import br.com.fiap.soat.pontos.entities.Ponto;

import br.com.fiap.soat.pontos.interfaces.gateways.PontoGatewayPort;
import br.com.fiap.soat.pontos.interfaces.usecases.ObterPontosPorUsuarioUseCasePort;
import org.springframework.stereotype.Component;

import java.util.List;

public class ObterPontosPorUsuarioUseCase implements ObterPontosPorUsuarioUseCasePort {
    private final PontoGatewayPort pontoGatewayPort;

    public ObterPontosPorUsuarioUseCase(PontoGatewayPort pontoGateway) {
        this.pontoGateway = pontoGateway;
    }

    public List<Ponto> execute(String usuario) {
        return pontoGateway.obterPontosPorUsuario(usuario);
    }
}




