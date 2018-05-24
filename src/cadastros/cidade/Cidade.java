package cidade;

import commons.cadastros.Cadastro;




public class Cidade extends Cadastro {

    private String nome;
    private Estado uf;

    public Cidade(String nome) {
        this.nome = nome;
    }

    public Cidade() {}

    public String getCidade() {
        return nome;
    }

    public void setCidade(String cidade) {
        this.nome = cidade;
    }
}