package cadastros.multa;

import commons.cadastros.Cadastro;
import commons.enuns.Estado;
import cadastros.infracao.Infracao;
import cadastros.orgao.Orgao;
import cadastros.proprietario.Proprietario;
import cadastros.veiculo.Veiculo;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Multa extends Cadastro{
    private Veiculo veiculo;
    private Infracao infracao;
    private Orgao orgao;
    private LocalDateTime dataHoraEmissao;
    private LocalDate dataVencimento;
    private String numero;
    private String rua;
    private String bairro
    private Cidade cidade;
    private String cep;
    private FatorMultiplicador fatorMultiplicador;
    private Proprietario condutor;
    private BigDecimal valorFinal;

    public Multa(Veiculo veiculo, Infracao infracao, Orgao orgao, LocalDateTime dataHoraEmissao, LocalDate dataVencimento, String numero, String rua, String bairro, Cidade cidade, FatorMultiplicador fatorMultiplicador, Proprietario condutor, BigDecimal valorFinal) {
        this.veiculo = veiculo;
        this.infracao = infracao;
        this.orgao = orgao;
        this.dataHoraEmissao = dataHoraEmissao;
        this.dataVencimento = dataVencimento;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.fatorMultiplicador = fatorMultiplicador;
        this.condutor = condutor;
        this.valorFinal = valorFinal;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Infracao getInfracao() {
        return infracao;
    }

    public void setInfracao(Infracao infracao) {
        this.infracao = infracao;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

    public LocalDateTime getDataHoraEmissao() {
        return dataHoraEmissao;
    }

    public void setDataHoraEmissao(LocalDateTime dataHoraEmissao) {
        this.dataHoraEmissao = dataHoraEmissao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public FatorMultiplicador getFatorMultiplicador() {
        return fatorMultiplicador;
    }

    public void setFatorMultiplicador(FatorMultiplicador fatorMultiplicador) {
        this.fatorMultiplicador = fatorMultiplicador;
    }

    public Proprietario getCondutor() {
        return condutor;
    }

    public void setCondutor(Proprietario condutor) {
        this.condutor = condutor;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    @Override
	public String toString() {
		return "Multa";
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
