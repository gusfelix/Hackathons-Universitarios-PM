package repository;

import java.util.ArrayList;
import java.util.List;
import model.evento.Apresentacao;

public class Apresentacoes {
    private static Apresentacoes instance;
    private final List<Apresentacao> colecaoApresentacoes;

    private Apresentacoes() {
        colecaoApresentacoes = new ArrayList<>();
    }

    public static Apresentacoes getInstance() {
        if (instance == null) {
            instance = new Apresentacoes();
        }
        return instance;
    }

    public void adicionar(Apresentacao apresentacao) {
        this.colecaoApresentacoes.add(apresentacao);
    }

    public List<Apresentacao> getColecaoApresentacoes() {
        return colecaoApresentacoes;
    }
}