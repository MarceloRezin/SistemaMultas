package cadastros.proprietario;

import banco.Banco;
import commons.cadastros.Cadastro;
import cadastros.condutor.Condutor;
import cadastros.pessoa.Pessoa;
import commons.utils.Utils;
import exception.SistemaMultasException;
import log.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Proprietario extends Cadastro{

    private Pessoa pessoa;
    private Condutor condutor;
    private Integer idPessoa;
    private Integer idCondutor;

    public Pessoa getPessoa() {

        if(pessoa == null && idPessoa != null){
            try {
                this.pessoa = (Pessoa) Banco.getById(new Pessoa(), idPessoa);
            }catch (SistemaMultasException e){
                e.printStackTrace();
                Logger.log(e.getMessage());
                Utils.mensagemErro("Ocorreu um erro ao recuperar a pessoa");
            }
        }
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Condutor getCondutor() {
        if(condutor == null && idCondutor != null){
            try {
                this.condutor = (Condutor) Banco.getById(new Condutor(), idCondutor);
            }catch (SistemaMultasException e){
                e.printStackTrace();
                Logger.log(e.getMessage());
                Utils.mensagemErro("Ocorreu um erro ao recuperar o condutor");
            }
        }

        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Integer getIdCondutor() {
        return idCondutor;
    }

    public void setIdCondutor(Integer idCondutor) {
        this.idCondutor = idCondutor;
    }

    @Override
	public String toString() {
		return getPessoa().getNomeRazaoSocial() + " / " + getPessoa().getCpfCnpj();
	}

    @Override
    public String getNomeTabela() {
        return "proprietarios";
    }

    @Override
    public String getColunas() {
        return "id_condutor,pessoa_id";
    }

    @Override
    public void setStatements(PreparedStatement stmt) throws SQLException {
        stmt.setInt(1,getCondutor().getId());
        stmt.setInt(2, getPessoa().getId());
    }

    @Override
    public List<Cadastro> resultSetToList(ResultSet rs) throws SQLException {
        List<Cadastro> listProprietario = new ArrayList<>();

        while (rs.next()){
            Proprietario proprietario = new Proprietario();

            proprietario.setId(rs.getInt("id"));
            proprietario.setIdCondutor(rs.getInt("id_condutor"));
            proprietario.setIdPessoa(rs.getInt("pessoa_id"));

            listProprietario.add(proprietario);
        }
        return listProprietario;
    }

    @Override
    public String getColunaOrdenacao() {
        return "id";
    }

    public static Proprietario valueOf(int id) {
        try {
            return (Proprietario) Banco.getById(new Proprietario(), id);
        } catch (SistemaMultasException e) {
            e.printStackTrace();
            Logger.log(e.getMessage());
            Utils.mensagemErro("Ocorreu um erro ao recuperar o veículo!");
            return null;
        }
    }
}
