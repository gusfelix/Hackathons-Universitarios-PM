package model.pessoa;

import model.instituicao.Instituicao;

public abstract class Pessoa {

    private String nome;
    private Instituicao instituicao;

    public Pessoa(String nome, Instituicao instituicao) {
        this.nome = nome;
        this.instituicao = instituicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome='" + nome + '\'' + ", instituicao=" + instituicao.getNome() + '}';
    }
}
