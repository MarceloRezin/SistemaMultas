package cadastros.veiculo;

import commons.cadastros.Cadastro;
import commons.enuns.Estado;
import cadastros.proprietario.Proprietario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Veiculo extends Cadastro{
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private Cidade cidade;
    private String renavam;
    private String corPredominante;
    private Proprietario proprietario;

    public Veiculo(String marca, String modelo, int ano, Estado estado, Cidade cidade, String renavam, String corPredominante, Proprietario proprietario, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cidade = cidade;
        this.renavam = renavam;
        this.corPredominante = corPredominante;
        this.proprietario = proprietario;
        this.placa = placa;
    }

    public Veiculo(){}

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getCorPredominante() {
        return corPredominante;
    }

    public void setCorPredominante(String corPredominante) {
        this.corPredominante = corPredominante;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
	public String toString() {
		return getMarca();
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
