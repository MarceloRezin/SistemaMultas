package proprietario;

import commons.cadastros.Cadastro;
import commons.enuns.Estado;

public class Proprietario extends Cadastro{

    private String nome;
    private String cpf;
    private String endereco;
    private String cidade;
    private Estado estado;
    private String codigoHabilitacao;

    public Proprietario(String nome, String cpf, String endereco, String cidade, Estado estado, String codigoHabilitacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.codigoHabilitacao = codigoHabilitacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getCodigoHabilitacao() {
        return codigoHabilitacao;
    }

    public void setCodigoHabilitacao(String codigoHabilitacao) {
        this.codigoHabilitacao = codigoHabilitacao;
    }

	@Override
	public String toString() {
		return getNome();
	}
}
