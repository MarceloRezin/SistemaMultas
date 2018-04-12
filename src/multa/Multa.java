package multa;

import commons.cadastros.Cadastro;
import commons.enuns.Estado;
import infracao.Infracao;
import orgao.Orgao;
import proprietario.Proprietario;
import veiculo.Veiculo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Multa extends Cadastro{
    private Veiculo veiculo;
    private Infracao infracao;
    private Orgao orgao;
    private LocalDateTime dataHoraEmissao;
    private LocalDate dataVencimento;
    private String endereco;
    private String cidade;
    private Estado estado;
    private FatorMultiplicador fatorMultiplicador;
    private Proprietario condutor;

    public Multa(Veiculo veiculo, Infracao infracao, Orgao orgao, LocalDateTime dataHoraEmissao, LocalDate dataVencimento, String endereco, String cidade, Estado estado, FatorMultiplicador fatorMultiplicador, Proprietario condutor) {
        this.veiculo = veiculo;
        this.infracao = infracao;
        this.orgao = orgao;
        this.dataHoraEmissao = dataHoraEmissao;
        this.dataVencimento = dataVencimento;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.fatorMultiplicador = fatorMultiplicador;
        this.condutor = condutor;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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

	@Override
	public String toString() {
		return "Multa";
	}
}
