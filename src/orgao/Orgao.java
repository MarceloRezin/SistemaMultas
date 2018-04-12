package orgao;

import commons.cadastros.Cadastro;
import commons.enuns.Estado;

public class Orgao extends Cadastro	{

    private String nome;
    private String endereco;
    private String cidade;
    private Estado estado;

    public Orgao(String nome, String endereco, String cidade, Estado estado) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

	@Override
	public String toString() {
		return getNome();
	}
}
