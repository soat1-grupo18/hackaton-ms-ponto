package br.com.fiap.soat.pontos.config;

import br.com.fiap.soat.pontos.controllers.PontoController;
import br.com.fiap.soat.pontos.interfaces.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerBeanConfig {
    @Bean
    public PontoController pontoController(CriarPontoUseCasePort criarPontoUseCase,
                                                   ObterPontosPorUsuarioUseCasePort obterPontosPorUsuarioUseCase) {
        return new PontoController(
                criarPontoUseCase,
                obterPontosPorUsuarioUseCase,
    }
}
