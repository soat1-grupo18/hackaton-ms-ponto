package br.com.fiap.soat.pontos.config;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeConverter implements DynamoDBTypeConverter<String, LocalDateTime> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public String convert(LocalDateTime localDateTime) {
        return localDateTime != null ? localDateTime.format(formatter) : null;
    }

    @Override
    public LocalDateTime unconvert(String stringValue) {
        return stringValue != null ? LocalDateTime.parse(stringValue, formatter) : null;
    }
}
