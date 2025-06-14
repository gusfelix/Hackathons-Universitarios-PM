package app;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import model.evento.*;
import model.instituicao.*;
import model.pessoa.*;
import repository.Apresentacoes;
import repository.Equipes;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema de gerenciamento do Hackathon Universitário\n");

        // Instituições
        Universidade puc = new Universidade("PUC Minas");
        Universidade ufmg = new Universidade("UFMG");
        Universidade usp = new Universidade("USP");

        System.out.println("--- Criando Equipes ---");
        Equipes equipesManager = Equipes.getInstance();

        // Equipe 1:
        Equipe equipe1 = new Equipe("Equipe X");
        for (int i = 1; i <= 5; i++) {
            equipe1.adicionarMembro(new Estudante("Aluno " + i, puc));
        }
        equipesManager.adicionar(equipe1);
        System.out.println("'"+ equipe1.getNome() +"' criada.");

        // Equipe 2:
        Equipe equipe2 = new Equipe("Equipe Y");
        for (int i = 6; i <= 10; i++) {
            equipe2.adicionarMembro(new Estudante("Aluno " + i, puc));
        }
        equipesManager.adicionar(equipe2);
        System.out.println("'"+ equipe2.getNome() +"' criada.");

        // Criação dos Projetos e Orientadores
        System.out.println("--- Adicionando Projetos ---");
        Profissional orientador1 = new Profissional("Prof. Sandro", puc);
        Profissional orientador2 = new Profissional("Profa. Luciana", puc);

        Projeto projeto1 = new Projeto("Sistema de Gestão Acadêmica", orientador1, equipe1);
        Projeto projeto2 = new Projeto("App de Caronas Universitárias", orientador2, equipe2);
        System.out.println("Projeto 1: '" + projeto1.getNome() + "' associado à equipe '" + equipe1.getNome() + "'.");
        System.out.println("Projeto 2: '" + projeto2.getNome() + "' associado à equipe '" + equipe2.getNome() + "'.\n");

        // Criação das Bancas e Jurados
        System.out.println("--- Montando Bancas Avaliadoras ---");
        Banca banca1 = new Banca(projeto1);
        banca1.adicionarJurado(new Jurado("Jurado A", ufmg), 8);
        banca1.adicionarJurado(new Jurado("Jurado B", usp), 9);
        banca1.adicionarJurado(new Jurado("Jurado C", ufmg), 7);
        banca1.adicionarJurado(new Jurado("Jurado D", usp), 8);
        System.out.println("Banca para o projeto 1 criada com 4 jurados.");

        Banca banca2 = new Banca(projeto2);
        banca2.adicionarJurado(new Jurado("Jurado E", ufmg), 6);
        banca2.adicionarJurado(new Jurado("Jurado F", usp), 7);
        banca2.adicionarJurado(new Jurado("Jurado G", ufmg), 5);
        banca2.adicionarJurado(new Jurado("Jurado H", usp), 6);
        System.out.println("Banca para o projeto 2 criada com 4 jurados.\n");

        // Agendamento e realização das apresentações/avaliações
        System.out.println("--- Agendando e Realizando Avaliações ---");
        Apresentacoes apresentacoesManager = Apresentacoes.getInstance();

        Sala sala1 = new Sala("101", "Prédio 3");
        Apresentacao ap1 = new Apresentacao(projeto1, banca1, sala1, LocalDateTime.now().plusHours(1));
        apresentacoesManager.adicionar(ap1);

        Sala sala2 = new Sala("102", "Prédio 3");
        Apresentacao ap2 = new Apresentacao(projeto2, banca2, sala2, LocalDateTime.now().plusHours(2));
        apresentacoesManager.adicionar(ap2);

        // Simula a avaliação
        ap1.avaliar();
        ap2.avaliar();
        System.out.println();

        // Listagem dos projetos aprovados
        System.out.println("--- Projetos Aprovados (Nota Final >= 7) ---");
        List<Projeto> todosOsProjetos = apresentacoesManager.getColecaoApresentacoes()
                .stream()
                .map(Apresentacao::getProjeto)
                .collect(Collectors.toList());

        List<Projeto> projetosAprovados = todosOsProjetos.stream()
                .filter(p -> p.getNotaFinal() >= 7)
                .collect(Collectors.toList());

        if (projetosAprovados.isEmpty()) {
            System.out.println("Nenhum projeto foi aprovado.");
        } else {
            projetosAprovados.forEach(System.out::println);
        }
    }
}