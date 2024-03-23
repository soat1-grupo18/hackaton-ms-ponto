package br.com.fiap.soat.pontos.api;

import br.com.fiap.soat.pontos.api.requests.PontoRequest;
import br.com.fiap.soat.pontos.controllers.PontoController;
import br.com.fiap.soat.pontos.presenters.PontoPresenter;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;

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

    @Operation(summary = "Criar um ponto", description = "Cria um ponto a partir de uma matrícula ou nome de usuário.")
    @PostMapping("/pontos")
    public ResponseEntity<PontoPresenter> criarPonto(@Valid @RequestBody PontoRequest pontoRequest) {
        return ResponseEntity.ok(pontoController.criarPonto(pontoRequest.toDomain()));
    }

    @Operation(summary = "Obter pontos", description = "Retorna uma lista de pontos filtrada por matrícula ou nome de usuário.")
    @GetMapping("/pontos/{usuario}")
    public ResponseEntity<List<PontoPresenter>> obterPontos(
            @PathVariable(name = "usuario", required = true) String usuario,
            @RequestParam(name = "data_inicial", required = false) String dataInicial,
            @RequestParam(name = "data_final", required = false) String dataFinal) {

        try {
            if (dataInicial != null && dataFinal == null) {
                return ResponseEntity.status(400).build();
            }

            List<PontoPresenter> pontos;

            pontos = pontoController.obterPontosPorUsuario(usuario, dataInicial, dataFinal);
            return ResponseEntity.ok(pontos);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.ok(List.of());
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }
}
