package cadastros.gravidademulta;

import banco.Banco;
import commons.cadastros.Cadastro;
import commons.utils.Utils;
import exception.SistemaMultasException;
import log.Logger;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Leve: 88.38, 3
 * Média: 130.16, 4
 * Grave: 195.23, 5
 * Gravíssima, 293.47, 7

 */

public class GravidadeMulta extends Cadastro{
    private TipoMulta tipoMulta;
    private BigDecimal valor;
    private int pontos;

    public GravidadeMulta() {}

    public GravidadeMulta(TipoMulta tipoMulta, BigDecimal valor, int pontos) {
        this.tipoMulta = tipoMulta;
        this.valor = valor;
        this.pontos = pontos;
    }

    public TipoMulta getTipoMulta() {
        return tipoMulta;
    }

    public void setTipoMulta(TipoMulta tipoMulta) {
        this.tipoMulta = tipoMulta;
    }

    public BigDecimal getValor() {
        return valor == null ? BigDecimal.ZERO : valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    @Override
    public String toString() {
        return getTipoMulta().getDescricao();
    }

    @Override
    public String getNomeTabela() {
        return "gravidade_multas";
    }

    @Override
    public String getColunas() {
        return "tipo,valor,num_pontos";
    }

    @Override
    public void setStatements(PreparedStatement stmt) throws SQLException {
        stmt.setString(1,getTipoMulta().toString());
        stmt.setBigDecimal(2, getValor());
        stmt.setInt(3, getPontos());
    }

    @Override
    public List resultSetToList(ResultSet rs) throws SQLException {
        List<Cadastro> gravidadeMultas = new ArrayList<>();

        while (rs.next()){
            GravidadeMulta gravidadeMulta = new GravidadeMulta();

            gravidadeMulta.setId(rs.getInt("id"));
            gravidadeMulta.setTipoMulta(TipoMulta.valueOf(rs.getString("tipo")));
            gravidadeMulta.setValor(rs.getBigDecimal("valor"));
            gravidadeMulta.setPontos(rs.getInt("num_pontos"));

            gravidadeMultas.add(gravidadeMulta);
        }
        return gravidadeMultas;
    }

    @Override
    public String getColunaOrdenacao() {
        return "tipo";
    }

    public static GravidadeMulta valueOf(Integer id){
        try {
            return (GravidadeMulta) Banco.getById(new GravidadeMulta(), id);
        } catch (SistemaMultasException e) {
            e.printStackTrace();
            Logger.log(e.getMessage());
            Utils.mensagemErro("Ocorreu um erro ao recuperar o veículo!");
            return null;
        }

    }
}
