package br.com.fiap.soat.pontos.usecases;

import br.com.fiap.soat.pontos.interfaces.usecases.EmailService;

public class PontoService {
    private EmailService emailService;

    public PontoService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void enviarRelatorioDePontos(String destinatario, String relatorio) {
        String assunto = "Relatório de Pontos";
        emailService.sendEmail(destinatario, assunto, relatorio);
    }
}
