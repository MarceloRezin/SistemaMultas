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
    private Integer idGravidadeMulta;

    public Infracao(){}

    public Infracao(String descricao, GravidadeMulta gravidadeMulta) {
        this.descricao = descricao;
        this.gravidadeMulta = gravidadeMulta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public GravidadeMulta getGravidadeMulta() {
        if(gravidadeMulta == null && idGravidadeMulta != null){
            try {
                this.gravidadeMulta = (GravidadeMulta)Banco.getById(new GravidadeMulta(), idGravidadeMulta);
            }catch (SistemaMultasException e){
                e.printStackTrace();
                Logger.log(e.getMessage());
                Utils.mensagemErro("Ocorreu um erro!");
            }
        }
        return gravidadeMulta;
    }

    public void setGravidadeMulta(GravidadeMulta gravidadeMulta) {
        this.gravidadeMulta = gravidadeMulta;
    }

    public Integer getIdGravidadeMulta() {
        return idGravidadeMulta;
    }

    public void setIdGravidadeMulta(Integer idGravidadeMulta) {
        this.idGravidadeMulta = idGravidadeMulta;
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
        return "descricao,gravidade_multas_id";
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
            infracao.setIdGravidadeMulta(rs.getInt("gravidade_multas_id"));

            listInfracao.add(infracao);
        }
        return listInfracao;
    }

    @Override
    public String getColunaOrdenacao() {
        return  "descricao";
    }
}
