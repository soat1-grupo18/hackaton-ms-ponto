package br.com.fiap.soat.pontos.controllers;

import br.com.fiap.soat.pontos.api.requests.PontoRequest;
import br.com.fiap.soat.pontos.interfaces.usecases.CriarPontoUseCasePort;
import br.com.fiap.soat.pontos.interfaces.usecases.ObterPontoPorUsuarioUseCasePort;
import br.com.fiap.soat.pontos.entities.Ponto;
import br.com.fiap.soat.pontos.presenters.PontoPresenter;

import java.util.List;
import java.util.stream.Collectors;

public class PontoController {
    private final CriarPontoUseCasePort criarPontoUseCase;
    private final ObterPontoPorUsuarioUseCasePort obterPontoPorUsuarioUseCase;

    public PontoController(CriarPontoUseCasePort criarPontoUseCase,
                           ObterPontoPorUsuarioUseCasePort obterPontoPorUsuarioUseCase) {

        this.criarPontoUseCase = criarPontoUseCase;
        this.obterPontoPorUsuarioUseCase = obterPontoPorUsuarioUseCase;
    }

    public PontoPresenter criarPonto(Ponto ponto) {
        return PontoPresenter.fromDomain(criarPontoUseCase.execute(ponto));
    }

    public List<PontoPresenter> obterPontosPorUsuario(String usuario) {
        List<Pontos> pontos = obterPontoPorUsuarioUseCase.execute(usuario);
        return pontos.stream().map(PontoPresenter::fromDomain).collect(Collectors.toList());
    }
}
