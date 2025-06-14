package model.evento;

import java.time.LocalDateTime;

public class Apresentacao {
    private Projeto projeto;
    private Banca banca;
    private Sala local;
    private LocalDateTime dataHora;

    public Apresentacao(Projeto projeto, Banca banca, Sala local, LocalDateTime dataHora) {
        this.projeto = projeto;
        this.banca = banca;
        this.local = local;
        this.dataHora = dataHora;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void avaliar() {
        System.out.println("Avaliando projeto: " + projeto.getNome() + "...");
        banca.calcularNotaFinal();
        System.out.println("Avaliação concluída. Nota final: " + String.format("%.2f", projeto.getNotaFinal()));
    }
}