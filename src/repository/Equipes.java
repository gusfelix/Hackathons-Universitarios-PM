package repository;

import java.util.ArrayList;
import java.util.List;
import model.evento.Equipe;

public class Equipes {
    private static Equipes instance;
    private final List<Equipe> colecaoEquipes;

    private Equipes() {
        colecaoEquipes = new ArrayList<>();
    }

    public static Equipes getInstance() {
        if (instance == null) {
            instance = new Equipes();
        }
        return instance;
    }

    public void adicionar(Equipe equipe) {
        this.colecaoEquipes.add(equipe);
    }

    public List<Equipe> getColecaoEquipes() {
        return colecaoEquipes;
    }
}