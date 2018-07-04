package cadastros.infracao;

import banco.Banco;
import commons.cadastros.Cadastro;
import cadastros.gravidademulta.GravidadeMulta;
import commons.utils.Utils;
import exception.SistemaMultasException;
import log.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Infracao extends Cadastro{
    private String descricao;
    private GravidadeMulta gravidadeMulta;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public GravidadeMulta getGravidadeMulta() {
        return gravidadeMulta;
    }

    public void setGravidadeMulta(GravidadeMulta gravidadeMulta) {
        this.gravidadeMulta = gravidadeMulta;
    }

    @Override
	public String toString() {
		return getDescricao();
	}

    @Override
    public String getNomeTabela() {
        return "infracoes";
    }

    @Override
    public String getColunas() {
        return "descricao,gravidade_multa_id";
    }

    @Override
    public void setStatements(PreparedStatement stmt) throws SQLException {
        stmt.setString(1,getDescricao());
        stmt.setInt(2,getGravidadeMulta().getId());
    }

    @Override
    public List<Cadastro> resultSetToList(ResultSet rs) throws SQLException {

        List<Cadastro> listInfracao = new ArrayList<>();

        while (rs.next()){
            Infracao infracao = new Infracao();

            infracao.setId(rs.getInt("id"));
            infracao.setDescricao(rs.getString("descricao"));
            infracao.setGravidadeMulta(GravidadeMulta.valueOf((rs.getInt("gravidade_multa_id"))));

            listInfracao.add(infracao);
        }
        return listInfracao;
    }

    @Override
    public String getColunaOrdenacao() {
        return  "descricao";
    }

    public static Infracao valueOf(int id){
        try {
            return (Infracao) Banco.getById(new Infracao(), id);
        } catch (SistemaMultasException e) {
            e.printStackTrace();
            Logger.log(e.getMessage());
            Utils.mensagemErro("Ocorreu um erro ao recuperar o veículo!");
            return null;
        }
    }

    //Copia os estados da origem para o destino
    public static void mesclar(Infracao origem, Infracao destino){
        destino.setId(origem.getId());
        destino.setDescricao(origem.getDescricao());
        destino.setGravidadeMulta(origem.getGravidadeMulta());
    }
}
