package cadastros.infracao;

import commons.cadastros.Cadastro;
import cadastros.gravidademulta.GravidadeMulta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Infracao extends Cadastro{
    private String descricao;
    private GravidadeMulta gravidadeMulta;

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
        return "descricao,gravidade_multas_id";
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
