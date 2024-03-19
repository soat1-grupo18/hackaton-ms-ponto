package br.com.fiap.soat.pontos.usecases;

import br.com.fiap.soat.pontos.api.requests.PontoRequest;
import br.com.fiap.soat.pontos.entities.Ponto;
import br.com.fiap.soat.pontos.interfaces.gateways.PontoGatewayPort;
import br.com.fiap.soat.pontos.interfaces.usecases.CriarPontoUseCasePort;

public class CriarPontoUseCase implements CriarPontoUseCasePort {
    private final PontoGatewayPort pontoGateway;

    public CriarPontoUseCase(PontoGatewayPort pontoGateway) {
        this.pontoGateway = pontoGateway;
    }

    @Override
    public Ponto execute(Ponto ponto) {
        return pontoGateway.criarPonto(ponto);
    }
}

