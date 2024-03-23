package br.com.fiap.soat.pontos.dynamodb.mappers;

import br.com.fiap.soat.pontos.dynamodb.entities.PontoDynamoEntity;
import br.com.fiap.soat.pontos.entities.Ponto;
import br.com.fiap.soat.pontos.entities.TipoPonto;

public class PontoMapper {
    public static Ponto toDomain(PontoDynamoEntity entity) {
        return new Ponto(
                entity.getId(),
                entity.getUsuario(),
                entity.getData(),
                TipoPonto.valueOf(entity.getTipo())
        );
    }

    public static PontoDynamoEntity toEntity(Ponto ponto) {
        PontoDynamoEntity pontoDynamoEntity = new PontoDynamoEntity();

        pontoDynamoEntity.setId(ponto.getId());
        pontoDynamoEntity.setUsuario(ponto.getUsuario());
        pontoDynamoEntity.setData(ponto.getData());
        pontoDynamoEntity.setTipo(ponto.getTipo().name());

        return pontoDynamoEntity;
    }
}
