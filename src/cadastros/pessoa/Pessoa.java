package cadastros.pessoa;

import banco.Banco;
import cadastros.cidade.Cidade;
import commons.cadastros.Cadastro;
import commons.utils.Utils;
import exception.SistemaMultasException;
import log.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private Integer idCidade;

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

    public Cidade getCidade(){
        if(cidade == null && idCidade != null){
            try {
                this.cidade = (Cidade)Banco.getById(new Cidade(), idCidade);
            }catch (SistemaMultasException e){
                e.printStackTrace();
                Logger.log(e.getMessage());
                Utils.mensagemErro("Ocorreu um erro!");
            }
        }
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

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    @Override
    public String toString() {
        return getNomeRazaoSocial() +  " / " + getCpfCnpj();
    }

    @Override
    public String getNomeTabela() {
        return "pessoas";
    }

    @Override
    public String getColunas() {
        return "cpf_cnpj,nome_razao_social,rg_inscricao_estadual,numero,rua,bairro,cidades_id,cep,telefone,email,tipo_pessoa";
    }

    @Override
    public void setStatements(PreparedStatement stmt) throws SQLException{
        stmt.setString(1,getCpfCnpj());
        stmt.setString(2, getNomeRazaoSocial());
        stmt.setString(3, getRgInscricaoEstadual());
        stmt.setString(4, getNumero());
        stmt.setString(5, getRua());
        stmt.setString(6, getBairro());
        stmt.setInt(7, getCidade().getId());
        stmt.setString(8, getCep());
        stmt.setString(9, getTelefone());
        stmt.setString(10, getEmail());
        stmt.setString(11, getTipoPessoa().toString());

    }

    @Override
    public List<Cadastro> resultSetToList(ResultSet rs) throws SQLException {
        List<Cadastro> pessoas = new ArrayList<>();

        while (rs.next()){
            Pessoa pessoa = new Pessoa();

            pessoa.setId(rs.getInt("id"));
            pessoa.setCpfCnpj(rs.getString("cpf_cnpj"));
            pessoa.setNomeRazaoSocial(rs.getString("nome_razao_social"));
            pessoa.setRgInscricaoEstadual(rs.getString("rg_inscricao_estadual"));
            pessoa.setNumero(rs.getString("numero"));
            pessoa.setRua(rs.getString("rua"));
            pessoa.setBairro(rs.getString("bairro"));
            pessoa.setIdCidade(rs.getInt("cidades_id"));
            pessoa.setCep(rs.getString("cep"));
            pessoa.setTelefone(rs.getString("telefone"));
            pessoa.setEmail(rs.getString("email"));
            pessoa.setTipoPessoa(TipoPessoa.valueOf(rs.getString("tipo_pessoa")));

            pessoas.add(pessoa);
        }
        return pessoas;
    }

    @Override
    public String getColunaOrdenacao() {
        return "nome_razao_social";
    }
}
