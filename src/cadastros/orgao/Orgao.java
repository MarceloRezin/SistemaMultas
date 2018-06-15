package cadastros.orgao;

import banco.Banco;
import cadastros.cidade.Cidade;
import commons.cadastros.Cadastro;
import commons.utils.Utils;
import exception.SistemaMultasException;
import log.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Orgao extends Cadastro	{

    private String nome;
    private String numero;
    private String rua;
    private String bairro;
    private Cidade cidade;

    public Orgao(){}

    public Orgao(String nome, String numero, String rua, String bairro,Cidade cidade) {
        this.nome = nome;
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
	public String toString() {
		return getNome();
	}

    @Override
    public String getNomeTabela() {
        return "orgaos";
    }

    @Override
    public String getColunas() {
        return "nome,numero,rua,bairro,cidade_id";
    }

    @Override
    public void setStatements(PreparedStatement stmt) throws SQLException {
        stmt.setString(1,getNome());
        stmt.setString(2,getNumero());
        stmt.setString(3,getRua());
        stmt.setString(4,getBairro());
        stmt.setInt(5,getCidade().getId());
    }

    @Override
    public List<Cadastro> resultSetToList(ResultSet rs) throws SQLException {
        List<Cadastro> listOrgaos = new ArrayList<>();

        while (rs.next()){
            Orgao orgao = new Orgao();

            orgao.setId(rs.getInt("id"));
            orgao.setNome(rs.getString("nome"));
            orgao.setNumero(rs.getString("numero"));
            orgao.setRua(rs.getString("rua"));
            orgao.setBairro(rs.getString("bairro"));
            orgao.setCidade(Cidade.valueOf(rs.getInt("cidade_id")));



            listOrgaos.add(orgao);
        }
        return listOrgaos;
    }

    @Override
    public String getColunaOrdenacao() {
        return "nome";
    }

    public static Orgao valueOf(int id) {
        try {
            return (Orgao) Banco.getById(new Orgao(), id);
        } catch (SistemaMultasException e) {
            e.printStackTrace();
            Logger.log(e.getMessage());
            Utils.mensagemErro("Ocorreu um erro ao recuperar o veículo!");
            return null;
        }
    }
}
