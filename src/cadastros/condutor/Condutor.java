package cadastros.condutor;

import banco.Banco;
import commons.cadastros.Cadastro;
import cadastros.pessoa.Pessoa;
import commons.utils.Utils;
import exception.SistemaMultasException;
import log.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        return "condutores";
    }

    @Override
    public String getColunas() {
        return "codigo_hab,pessoa_id";
    }

    @Override
    public void setStatements(PreparedStatement stmt) throws SQLException {
        stmt.setString(1,getCodHabilitacao());
        stmt.setInt(2, getPessoa().getId());

    }

    @Override
    public List resultSetToList(ResultSet rs) throws SQLException {
        List<Cadastro> listCondutor = new ArrayList<>();

        while (rs.next()){
            Condutor condutor = new Condutor();

            condutor.setId(rs.getInt("id"));
            condutor.setCodHabilitacao(rs.getString("codigo_hab"));
            condutor.setPessoa(Pessoa.valueOf(rs.getInt("pessoa_id")));

            listCondutor.add(condutor);
        }
        return listCondutor;
    }

    @Override
    public String getColunaOrdenacao() {
        return "codigo_hab";
    }

    public static Condutor valueOf(int id) {
        try {
            return (Condutor) Banco.getById(new Condutor(), id);
        } catch (SistemaMultasException e) {
            e.printStackTrace();
            Logger.log(e.getMessage());
            Utils.mensagemErro("Ocorreu um erro ao recuperar o condutor!");
            return null;
        }
    }

    //Copia os estados da origem para o destino
    public static void mesclar(Condutor origem, Condutor destino){
        destino.setId(origem.getId());
        destino.setPessoa(origem.getPessoa());
        destino.setCodHabilitacao(origem.getCodHabilitacao());
    }
}
