package br.com.fiap.soat.pontos.config;

import br.com.fiap.soat.pontos.dynamodb.entities.PontoDynamoEntity;
import br.com.fiap.soat.pontos.dynamodb.repositories.PontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


import java.util.Arrays;
import java.util.List;

@Configuration
public class DynamoDBDataInitializer {

    @Autowired
    private PontoRepository pontoRepository;

    @Bean
    @Profile("!aws")
    public CommandLineRunner initializeData(PontoRepository pontoRepository) {
        return args -> {
            List<String> usernames = Arrays.asList("pablold", "mvsouza", "gisele_m", "olegon");
            List<String> timestamps = Arrays.asList("2024-02-20T09:00:00", "2024-02-20T12:30:00", "2024-02-20T13:30:00", "2024-02-20T18:00:00");

            for (String username : usernames) {
                for (String timestamp : timestamps) {
                    PontoDynamoEntity ponto = new PontoDynamoEntity();
                    ponto.setUsuario(username);
                    ponto.setData(timestamp);
                    pontoRepository.save(ponto);
                }
            }
        };
    }
}
