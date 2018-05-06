package pessoa;

import commons.cadastros.Cadastro;
import commons.enuns.Estado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Pessoa extends Cadastro{

    private String cpfCnpj;
    private String nomeRazaoSocial;
    private String rgInscricaoEstadual;
    private String endereco;
    private String cidade;
    private Estado estado;
    private String cep;
    private String telefone;
    private String email;
    private TipoPessoa tipoPessoa;

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNomeRazaoSocial() {
        return nomeRazaoSocial;
    }

    public void setNomeRazaoSocial(String nomeRazaoSocial) {
        this.nomeRazaoSocial = nomeRazaoSocial;
    }

    public String getRgInscricaoEstadual() {
        return rgInscricaoEstadual;
    }

    public void setRgInscricaoEstadual(String rgInscricaoEstadual) {
        this.rgInscricaoEstadual = rgInscricaoEstadual;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public String toString() {
        return getNomeRazaoSocial() +  "/" + getCpfCnpj();
    }

    @Override
    public String getNomeTabela() {
        return "pessoas";
    }

    @Override
    public String getColunas() {
        return "cpf_cnpj,nome_razao_social,rg_inscricao_estadual,endereco,cidade,estado,cep,telefone,email,tipo_pessoa";
    }

    @Override
    public void setStatements(PreparedStatement stmt) throws SQLException {
    }

    @Override
    public List<Cadastro> resultSetToList(ResultSet rs) throws SQLException {
        return null;
    }
}
