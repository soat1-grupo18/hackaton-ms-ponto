package br.com.fiap.soat.pontos.usecases;

import br.com.fiap.soat.pontos.interfaces.usecases.EmailService;

public class MockEmailService implements EmailService {

    @Override
    public void sendEmail(String to, String subject, String body) {
        System.out.println("Simulando envio de e-mail para: " + to);
        System.out.println("Assunto: " + subject);
        System.out.println("Corpo: " + body);
        System.out.println("E-mail enviado com sucesso!");
    }
}
