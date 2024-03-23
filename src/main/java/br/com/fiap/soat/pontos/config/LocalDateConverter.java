package br.com.fiap.soat.pontos.dynamodb.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateConverter implements DynamoDBTypeConverter<String, LocalDate> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public String convert(LocalDate localDate) {
        return localDate != null ? localDate.format(formatter) : null;
    }

    @Override
    public LocalDate unconvert(String stringValue) {
        return stringValue != null ? LocalDate.parse(stringValue, formatter) : null;
    }
}
