package model.evento;

import model.pessoa.Profissional;

public class Projeto {
    private String nome;
    private Profissional orientador;
    private Equipe equipe;
    private double notaFinal;

    public Projeto(String nome, Profissional orientador, Equipe equipe) {
        this.nome = nome;
        this.orientador = orientador;
        this.equipe = equipe;
    }

    public String getNome() {
        return nome;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return "Projeto{" + "nome='" + nome + '\'' + ", equipe=" + equipe.getNome() + ", notaFinal=" + String.format("%.2f", notaFinal) + '}';
    }
}
