package br.com.fiap.soat.pontos.controllers;

import br.com.fiap.soat.pontos.interfaces.usecases.CriarPontoUseCasePort;
import br.com.fiap.soat.pontos.interfaces.usecases.ObterPontosPorUsuarioUseCasePort;
import br.com.fiap.soat.pontos.entities.Ponto;
import br.com.fiap.soat.pontos.presenters.PontoPresenter;

import java.util.List;
import java.util.stream.Collectors;

public class PontoController {
    private final CriarPontoUseCasePort criarPontoUseCase;
    private final ObterPontosPorUsuarioUseCasePort obterPontosPorUsuarioUseCase;

    public PontoController(CriarPontoUseCasePort criarPontoUseCase,
                           ObterPontosPorUsuarioUseCasePort obterPontosPorUsuarioUseCase) {

        this.criarPontoUseCase = criarPontoUseCase;
        this.obterPontosPorUsuarioUseCase = obterPontosPorUsuarioUseCase;
    }

    public PontoPresenter criarPonto(Ponto ponto) {
        return PontoPresenter.fromDomain(criarPontoUseCase.execute(ponto));
    }

    public List<PontoPresenter> obterPontosPorUsuario(String usuario, String dataInicial, String dataFinal) {
        List<Ponto> pontos = obterPontosPorUsuarioUseCase.execute(usuario, dataInicial, dataFinal);
        return pontos.stream().map(PontoPresenter::fromDomain).collect(Collectors.toList());
    }
}
