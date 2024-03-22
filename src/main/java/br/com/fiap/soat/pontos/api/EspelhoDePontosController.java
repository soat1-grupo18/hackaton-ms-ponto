package br.com.fiap.soat.pontos.api;

import br.com.fiap.soat.pontos.entities.Ponto;
import br.com.fiap.soat.pontos.interfaces.usecases.ObterEspelhoDePontosUsuarioUseCasePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@Tag(name = "Espelho de Pontos")
public class EspelhoDePontosController {
    private final ObterEspelhoDePontosUsuarioUseCasePort obterEspelhoDePontosUsuarioUseCase;

    public EspelhoDePontosController(ObterEspelhoDePontosUsuarioUseCasePort obterEspelhoDePontosUsuarioUseCase) {
        this.obterEspelhoDePontosUsuarioUseCase = obterEspelhoDePontosUsuarioUseCase;
    }

    @Operation(summary = "Espelho de pontos", description = "Retorna o espelho de pontos referente ao último mês fechado do funcionário.")
    @GetMapping("/pontos/espelho-mes-anterior/{usuario}")
    public ResponseEntity<List<Ponto>> obterEspelhoDePontosUsuarioEPeriodo(@PathVariable String usuario) {
        LocalDate dataInicio = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        LocalDate dataFim = LocalDate.now().minusMonths(1).withDayOfMonth(dataInicio.lengthOfMonth());

        List<Ponto> pontos = obterEspelhoDePontosUsuarioUseCase.obterEspelhoDePontosPorUsuarioEPeriodo(usuario, dataInicio, dataFim);

        return ResponseEntity.ok(pontos);
    }
}
