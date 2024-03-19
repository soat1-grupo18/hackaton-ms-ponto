package br.com.fiap.soat.pontos.config;
import br.com.fiap.soat.pontos.interfaces.gateways.PontoGatewayPort;
import br.com.fiap.soat.pontos.interfaces.usecases.*;
import br.com.fiap.soat.pontos.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {
    @Bean("criarPontoUseCasePort")
    public CriarPontoUseCasePort criarPontoUseCasePort(PontoGatewayPort pontoGatewayPort) {
        return new CriarPontoUseCase(pontoGatewayPort);
    }

    @Bean("obterPontoPorIdUseCasePort")
    public ObterPontoPorUsuarioUseCasePort obterPontoPorUsuarioUseCasePort(PontoGatewayPort pontoGatewayPort) {
        return new ObterPontoPorUsuarioUseCase(pontoGatewayPort);
    }
}
