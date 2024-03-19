package br.com.fiap.soat.pontos.api;
import br.com.fiap.soat.pontos.api.requests.PontoRequest;
import br.com.fiap.soat.pontos.controllers.PontoController;
import br.com.fiap.soat.pontos.presenters.PontoPresenter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@Tag(name = "API de Pontos")
public class PontoApi {
    private final PontoController pontoController;

    public PontoApi(PontoController pontoController) {
        this.pontoController = pontoController;
    }

    @Operation(summary = "Criar um ponto",
            description = "Cria um ponto a partir de uma matrícula ou nome de usuário.")
    @PostMapping("/pontos")
    public ResponseEntity<PontoPresenter> criarPonto(@Valid @RequestBody PontoRequest pontoRequest) {
        return ResponseEntity.ok(pontoController.cirarPonto(pontoRequest.toDomain()));
    }

    @Operation(summary = "Obter pontos", description = "Retorna uma lista de pontos filtrada por matrícula ou nome de usuário.")
    @GetMapping("/pontos/{usuario}")
    public ResponseEntity<List<PontoPresenter>> obterPontos(@PathVariable(name = "usuario", required = true) String usuario) {
        List<PontoPresenter> pontos;

        pontos = pontoController.obterPontosPorUsuario(usuario);

        return ResponseEntity.ok(pontos);
    }
}
