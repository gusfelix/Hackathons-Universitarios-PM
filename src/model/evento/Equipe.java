package model.evento;

import java.util.ArrayList;
import java.util.List;
import model.pessoa.*;

public class Equipe {
    private String nome;
    private List<Estudante> membros;

    public Equipe(String nome) {
        this.nome = nome;
        this.membros = new ArrayList<>();
    }

    public void adicionarMembro(Estudante estudante) {
        if (membros.size() < 5) { // Limite de 5 membros por equipe
            this.membros.add(estudante);
        } else {
            System.out.println("A equipe " + this.nome + " já está cheia.");
        }
    }

    public String getNome() {
        return nome;
    }

    public List<Estudante> getMembros() {
        return membros;
    }

    @Override
    public String toString() {
        return "Equipe{" + "nome='" + nome + '\'' + ", membros=" + membros.size() + '}';
    }
}