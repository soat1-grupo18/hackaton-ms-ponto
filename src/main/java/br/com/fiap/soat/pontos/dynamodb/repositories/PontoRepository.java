package br.com.fiap.soat.pontos.dynamodb.repositories;

import br.com.fiap.soat.pontos.dynamodb.entities.PontoDynamoEntity;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;

import java.util.List;
import java.util.Optional;

@EnableScan
public interface PontoRepository extends DynamoDBCrudRepository<PontoDynamoEntity, String> {
    List<PontoDynamoEntity> findByUsuario(String usuario);
}
