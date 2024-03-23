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
import java.time.LocalDateTime;
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
        LocalDateTime dataInicio = LocalDateTime.now().minusMonths(1).withDayOfMonth(1);
        LocalDateTime dataFim = LocalDateTime.now().minusMonths(1).withDayOfMonth(dataInicio.toLocalDate().lengthOfMonth()).withHour(23).withMinute(59).withSecond(59);

        List<Ponto> pontos = obterEspelhoDePontosUsuarioUseCase.obterEspelhoDePontosPorUsuarioEPeriodo(usuario, dataInicio, dataFim);

        enviarRelatorioDePontos("exemplo@email.com", "Relatório de pontos do mês...");

        return ResponseEntity.ok(pontos);
    }
    private void enviarRelatorioDePontos(String destinatario, String mensagem) {
        // Lógica para enviar o relatório de pontos
        System.out.println("Simulação: Relatório de pontos enviado para " + destinatario + ": " + mensagem);
    }
}
