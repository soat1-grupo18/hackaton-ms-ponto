package br.com.fiap.soat.pontos.dynamodb.repositories;

import br.com.fiap.soat.pontos.dynamodb.entities.PontoDynamoEntity;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import java.util.List;

@EnableScan
public interface PontoRepository extends DynamoDBCrudRepository<PontoDynamoEntity, String> {
    List<PontoDynamoEntity> findByUsuario(String usuario);
}
