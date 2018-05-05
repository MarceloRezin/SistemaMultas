package condutor;

import commons.cadastros.Cadastro;
import pessoa.Pessoa;

public class Condutor extends Cadastro{

    private Pessoa pessoa;
    private String codHabilitacao;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getCodHabilitacao() {
        return codHabilitacao;
    }

    public void setCodHabilitacao(String codHabilitacao) {
        this.codHabilitacao = codHabilitacao;
    }

    @Override
    public String toString() {
        return getPessoa().getNomeRazaoSocial() + " / " + getCodHabilitacao();
    }
}
