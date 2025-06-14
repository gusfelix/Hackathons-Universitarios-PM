package model.evento;

import java.util.HashMap;
import java.util.Map;
import model.pessoa.*;

public class Banca implements Avaliavel {
    private Projeto projetoAvaliado;
    private Map<Jurado, Integer> jurados;
    
    public Banca(Projeto projetoAvaliado) {
        this.projetoAvaliado = projetoAvaliado;
        this.jurados = new HashMap<>();
    }

    public void adicionarJurado(Jurado jurado, Integer nota) {
        if (jurados.size() < 4) { // Limite de 4 jurados por banca
            this.jurados.put(jurado, nota);
        } else {
            System.out.println("A banca para o projeto " + projetoAvaliado.getNome() + " já está completa.");
        }
    }

    @Override
    public void calcularNotaFinal() {
        if (jurados.isEmpty()) {
            projetoAvaliado.setNotaFinal(0);
            return;
        }
        double somaDasNotas = 0;
        for (Integer nota : jurados.values()) {
            somaDasNotas += nota;
        }
        double media = somaDasNotas / jurados.size();
        projetoAvaliado.setNotaFinal(media);
    }
}