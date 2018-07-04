package cadastros.multa;

import banco.Banco;
import cadastros.cidade.Cidade;
import cadastros.condutor.Condutor;
import commons.cadastros.Cadastro;
import cadastros.infracao.Infracao;
import cadastros.orgao.Orgao;
import cadastros.proprietario.Proprietario;
import cadastros.veiculo.Veiculo;
import commons.utils.Utils;
import exception.SistemaMultasException;
import javafx.scene.input.KeyCode;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private Condutor condutor;
    private BigDecimal valorFinal;


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

    public FatorMultiplicador getFatorMultiplicador() {
        return fatorMultiplicador;
    }

    public void setFatorMultiplicador(FatorMultiplicador fatorMultiplicador) {
        this.fatorMultiplicador = fatorMultiplicador;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
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
		return getVeiculo().getPlaca();
	}

    @Override
    public String getNomeTabela() {
        return "multas";
    }

    @Override
    public String getColunas() {
        return "veiculo_id,infracao_id,orgao_id,data_hora_emissao,data_vencimento,numero,rua,bairro,cidade_id,fator_multiplicador,condutor_id,valor_final";
    }

    @Override
    public void setStatements(PreparedStatement stmt) throws SQLException {

        stmt.setInt(1,getVeiculo().getId());
        stmt.setInt(2,getInfracao().getId());
        stmt.setInt(3,getOrgao().getId());
        stmt.setTimestamp(4, Timestamp.valueOf(getDataHoraEmissao()));
        stmt.setDate(5,java.sql.Date.valueOf(getDataVencimento()));
        stmt.setString(6,getNumero());
        stmt.setString(7,getRua());
        stmt.setString(8,getBairro());
        stmt.setInt(9,getCidade().getId());
        stmt.setString(10,getFatorMultiplicador().toString());
        if(Utils.cadastroIsNull(getCondutor())){
            stmt.setNull(11, Types.INTEGER);
        }else{
            stmt.setInt(11, getCondutor().getId());
        }
        stmt.setBigDecimal(12,getValorFinal());
    }

    @Override
    public List resultSetToList(ResultSet rs) throws SQLException {

        List<Cadastro> listMulta = new ArrayList<>();

        while (rs.next()){
            Multa multa = new Multa();

            multa.setId(rs.getInt("id"));
            multa.setVeiculo(Veiculo.valueOf(rs.getInt("veiculo_id")));
            multa.setInfracao(Infracao.valueOf(rs.getInt("infracao_id")));
            multa.setOrgao(Orgao.valueOf(rs.getInt("orgao_id")));
            multa.setDataHoraEmissao(java.sql.Timestamp.valueOf(rs.getString("data_hora_emissao")).toLocalDateTime().minusHours(3));
            multa.setDataVencimento(java.sql.Timestamp.valueOf(rs.getString("data_vencimento")).toLocalDateTime().toLocalDate());
            multa.setNumero(rs.getString("numero"));
            multa.setRua(rs.getString("rua"));
            multa.setBairro(rs.getString("bairro"));
            multa.setCidade(Cidade.valueOf(rs.getInt("cidade_id")));
            multa.setFatorMultiplicador(FatorMultiplicador.valueOf(rs.getString("fator_multiplicador")));
            int condutorId = rs.getInt("condutor_id");
            if(condutorId == 0){ //Pode ser nulo
                multa.setCondutor(null);
            }else{
                multa.setCondutor(Condutor.valueOf(condutorId));
            }
            multa.setValorFinal(rs.getBigDecimal("valor_final"));


            listMulta.add(multa);
        }
        return listMulta;
    }

    @Override
    public String getColunaOrdenacao() {
        return "id";
    }

    public static Multa valueOf(Integer id) throws SistemaMultasException{
        return (Multa) Banco.getById(new Multa(), id);
    }
}
