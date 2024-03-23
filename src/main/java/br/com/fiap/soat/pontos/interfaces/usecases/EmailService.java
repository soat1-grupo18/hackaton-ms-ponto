package br.com.fiap.soat.pontos.interfaces.usecases;

public interface EmailService {
    void sendEmail(String to, String subject, String body);
}
