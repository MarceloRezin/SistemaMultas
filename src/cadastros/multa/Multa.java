package cadastros.multa;

import banco.Banco;
import commons.cadastros.Cadastro;
import commons.enuns.Estado;
import cadastros.infracao.Infracao;
import cadastros.orgao.Orgao;
import cadastros.proprietario.Proprietario;
import cadastros.veiculo.Veiculo;
import commons.utils.Utils;
import exception.SistemaMultasException;
import log.Logger;

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
    private String bairro;
    private Cidade cidade;
    private FatorMultiplicador fatorMultiplicador;
    private Proprietario condutor;
    private BigDecimal valorFinal;
    private Integer idVeiculo;
    private Integer idInfracao;

    public Multa(Veiculo veiculo, Infracao infracao, Orgao orgao, LocalDateTime dataHoraEmissao, LocalDate dataVencimento, String numero, String rua, String bairro, Cidade cidade, FatorMultiplicador fatorMultiplicador, Proprietario condutor, BigDecimal valorFinal) {
        this.veiculo = veiculo;
        this.infracao = infracao;
        this.orgao = orgao;
        this.dataHoraEmissao = dataHoraEmissao;
        this.dataVencimento = dataVencimento;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.fatorMultiplicador = fatorMultiplicador;
        this.condutor = condutor;
        this.valorFinal = valorFinal;
    }

    public Veiculo getVeiculo() {
        if(veiculo == null && idVeiculo != null){
            try {
                this.veiculo = (Veiculo)Banco.getById(new Veiculo(), idVeiculo);
            }catch (SistemaMultasException e){
                e.printStackTrace();
                Logger.log(e.getMessage());
                Utils.mensagemErro("Ocorreu um erro!");
            }
        }
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Infracao getInfracao() {

        if(infracao == null && idInfracao != null){
            try {
                this.infracao = (Infracao)Banco.getById(new Infracao(),idInfracao);
            }catch (SistemaMultasException e){
                e.printStackTrace();
                Logger.log(e.getMessage());
                Utils.mensagemErro("Ocorreu um erro!");
            }
        }
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

    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Integer getIdInfracao() {
        return idInfracao;
    }

    public void setIdInfracao(Integer idInfracao) {
        this.idInfracao = idInfracao;
    }

    @Override
	public String toString() {
		return "Multa";
	}

    @Override
    public String getNomeTabela() {
        return "multas";
    }

    @Override
    public String getColunas() {
        return "veiculos_id,infracoes_id,orgaos_id,data_hora_emissao,data_vencimento,numero,rua,bairro,cidades_id,fator_multiplicador,id_condutor,valor_final";
    }

    @Override
    public void setStatements(PreparedStatement stmt) throws SQLException {

        stmt.setInt(1,getVeiculo().getId());
        stmt.setInt(2,getInfracao().getId());
        stmt.setInt(3,getOrgao().getId());

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
