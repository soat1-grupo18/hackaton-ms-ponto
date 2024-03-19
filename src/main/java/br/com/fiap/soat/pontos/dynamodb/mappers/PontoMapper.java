package br.com.fiap.soat.pontos.dynamodb.mappers;

import br.com.fiap.soat.pontos.dynamodb.entities.PontoDynamoEntity;
import br.com.fiap.soat.pontos.entities.Ponto;

public class PontoMapper {
    public static Ponto toDomain(PontoDynamoEntity entity) {
        return new Ponto(
                entity.getId(),
                entity.getUsuario(),
                entity.getData()
        );
    }

    public static PontoDynamoEntity toEntity(Ponto ponto) {
        PontoDynamoEntity pontoDynamoEntity = new PontoDynamoEntity();

        pontoDynamoEntity.setId(ponto.getId());
        pontoDynamoEntity.setUsuario(ponto.getUsuario());
        pontoDynamoEntity.setData(ponto.getData());

        return pontoDynamoEntity;
    }
}
