package veiculo;

import commons.cadastros.Cadastro;
import commons.enuns.Estado;
import proprietario.Proprietario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Veiculo extends Cadastro{
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private Estado estado;
    private String cidade;
    private String renavam;
    private String corPredominante;
    private Proprietario proprietario;

    public Veiculo(String marca, String modelo, int ano, Estado estado, String cidade, String renavam, String corPredominante, Proprietario proprietario, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.estado = estado;
        this.cidade = cidade;
        this.renavam = renavam;
        this.corPredominante = corPredominante;
        this.proprietario = proprietario;
        this.placa = placa;
    }

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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
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
}
