package cadastros.condutor;

import commons.cadastros.Cadastro;
import cadastros.pessoa.Pessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    @Override
    public String getNomeTabela() {
        return null;
    }

    @Override
    public String getColunas() {
        return null;
    }

    @Override
    public void setStatements(PreparedStatement stmt) throws SQLException {

    }

    @Override
    public List<Cadastro> resultSetToList(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    public String getColunaOrdenacao() {
        return null;
    }
}
