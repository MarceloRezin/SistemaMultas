package cadastros.cidade;

import banco.Banco;
import commons.cadastros.Cadastro;
import commons.utils.Utils;
import exception.SistemaMultasException;
import log.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Cidade extends Cadastro {

    private String nome;
    private Estado uf;

    public Cidade() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String cidade) {
        this.nome = cidade;
    }

    public Estado getUf() {
        return uf;
    }

    public void setUf(Estado uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public String getNomeTabela() {
        return "cidades";
    }

    @Override
    public String getColunas() {
        return "nome,uf";
    }

    @Override
    public void setStatements(PreparedStatement stmt) throws SQLException {
        stmt.setString(1,getNome());
        stmt.setString(2, getUf().toString());
    }

    @Override
    public List resultSetToList(ResultSet rs) throws SQLException {
        List<Cadastro> cidades = new ArrayList<>();

        while (rs.next()){
            Cidade cidade = new Cidade();

            cidade.setId(rs.getInt("id"));
            cidade.setNome(rs.getString("nome"));
            cidade.setUf(Estado.valueOf(rs.getString("uf")));

            cidades.add(cidade);
        }
        return cidades;
    }

    @Override
    public String getColunaOrdenacao() {
        return "nome";
    }

    //Copia os estados da origem para o destino
    public static void mesclar(Cidade origem, Cidade destino){
        destino.setId(origem.getId());
        destino.setUf(origem.getUf());
        destino.setNome(origem.getNome());
    }

    public static Cidade valueOf(int id) {
        try {
            return (Cidade) Banco.getById(new Cidade(), id);
        } catch (SistemaMultasException e) {
            e.printStackTrace();
            Logger.log(e.getMessage());
            Utils.mensagemErro("Ocorreu um erro ao recuperar o veículo!");
            return null;
        }
    }
}