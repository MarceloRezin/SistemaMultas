package cadastros.pessoa;

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
    private String numero;
    private String rua;
    private String bairro;
    private Cidade cidade;
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
        return "cpf_cnpj,nome_razao_social,rg_inscricao_estadual,numero,rua,bairro,cep,telefone,email,tipo_pessoa";
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
