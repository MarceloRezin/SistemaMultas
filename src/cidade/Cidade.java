package cidade;

import commons.cadastros.Cadastro;




public class Cidade extends Cadastro {
    private String nome;

    public String getCidade() {
        return nome;
    }

    public void setCidade(String cidade) {
        this.nome = cidade;
    }
}