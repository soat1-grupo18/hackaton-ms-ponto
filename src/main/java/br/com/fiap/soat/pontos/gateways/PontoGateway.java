package br.com.fiap.soat.pontos.gateways;

import br.com.fiap.soat.pontos.dynamodb.entities.PontoDynamoEntity;
import br.com.fiap.soat.pontos.dynamodb.repositories.PontoRepository;
import br.com.fiap.soat.pontos.entities.Ponto;
import br.com.fiap.soat.pontos.interfaces.gateways.PontoGatewayPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class PontoGateway implements PontoGatewayPort {
    public PontoGateway(PontoRepository pontoRepository) {
        this.pontoRepository = pontoRepository;
    }

    private final PontoRepository pontoRepository;

    @Override
    public Ponto criarPonto(Ponto ponto) {
        PontoDynamoEntity pontoDynamoEntity = PontoDynamoEntity.fromDomain(ponto);
        pontoRepository.save(pontoDynamoEntity);
        return pontoDynamoEntity.toDomain();
    }

    @Override
    public List<Ponto> obterPontosPorUsuario(String usuario, String dataInicial, String dataFinal) {
        List<PontoDynamoEntity> entities;

        if (dataInicial != null && dataFinal != null) {
            entities = pontoRepository.findByUsuarioAndDataBetween(usuario, dataInicial, dataFinal);
        } else {
            entities = pontoRepository.findByUsuario(usuario);
        }

        List<Ponto> pontos = entities.stream()
                .filter(Objects::nonNull)
                .map(PontoDynamoEntity::toDomain)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return pontos;
    }
}
