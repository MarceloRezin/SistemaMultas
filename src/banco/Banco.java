package banco;

import commons.utils.Utils;
import commons.cadastros.Cadastro;
import exception.SistemaMultasException;
import log.Logger;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public class Banco{

    private static final String HOST = "db4free.net";
    private static final String BANCO = "sistemamultas";
    private static final String USUARIO = "sistemamultas";
    private static final String SENHA = "sistemamultas@1013";
    private static final String URL = "jdbc:mysql://" + HOST + "/" + BANCO + "?useSSL=false";

    private static Connection conexao = null;

    private Banco(){ }

    public static Connection iniciarConexao() {
        if(conexao == null){
            try{
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
                System.out.println("======== CONEXÃO INICIADA ========");
            }catch (Exception e1){
                Utils.mensagemErro("Não foi possível se conectar a base de dados");
                Logger.logErro(e1.getMessage());
            }
        }

        return conexao;
    }

    public static Connection getConexao() {
        if(conexao == null){
            iniciarConexao();
        }

        return conexao;
    }

    public static void fecharConexao() {
        if(conexao != null){
            try{
                conexao.close();
                System.out.println("======== CONEXÃO FECHADA ========");
            }catch (Exception e1){
                Utils.mensagemErro("Não foi possível ao fechar a conexão com a base de dados");
                Logger.logErro(e1.getMessage());
            }
        }
    }

    public static void save(Cadastro cadastro) throws SistemaMultasException {
        String sql;

        boolean isNovo = cadastro.isNovo();

        if(isNovo){
            sql = "INSERT INTO " + cadastro.getNomeTabela() + "(" + cadastro.getColunas() + ") VALUES(" + cadastro.getColunasSubstituicao() + ")";
        }else{
            sql = "UPDATE " + cadastro.getNomeTabela() + " SET " +  cadastro.getColunas().replaceAll(",", " = ?, ") + " = ? WHERE id = " + cadastro.getId();
        }

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            cadastro.setStatements(stmt);
            stmt.execute();

            if (cadastro.isNovo()) {
                ResultSet resultSet = stmt.executeQuery("SELECT LAST_INSERT_ID()");
                if (resultSet.next()) {
                    cadastro.setId(resultSet.getInt("LAST_INSERT_ID()"));
                }
            }
            stmt.close();
        }catch (SQLIntegrityConstraintViolationException e){
            e.printStackTrace();
            Logger.log(e.getMessage());
            throw new SistemaMultasException("Já existe este item registrado!");
        }catch(Exception e1){
            e1.printStackTrace();
            Logger.log(e1.getMessage());
            throw new SistemaMultasException();
        }
    }

    public static List select(Cadastro cadastro) throws SistemaMultasException{
        return selectComWhere(cadastro, "");
    }

    public static List selectComPesquisa(Cadastro cadastro, String pesquisa) throws SistemaMultasException{
        return selectComWhere(cadastro, "WHERE upper(" + cadastro.getColunaPesquisa() + ") LIKE '%" + pesquisa.toUpperCase() + "%'");
    }

    public static List selectComWhere(Cadastro cadastro, String where) throws SistemaMultasException{
        //Em caso de select com join
        String tabela = cadastro.getNomeTabela();
        String colunas = tabela + ".id," + tabela + "." + cadastro.getColunas().replaceAll(",", "," + tabela + ".");
        String  sql = "SELECT " + colunas + " FROM " + tabela + (Utils.isNulaOuVazia(where) ? "" : " " + where) + " ORDER BY " + cadastro.getColunaOrdenacao() + " ASC";

        try{
            Statement st = conexao.createStatement();

            ResultSet rs = st.executeQuery(sql);

            return cadastro.resultSetToList(rs);

        }catch(Exception e){
            Logger.log(e.getMessage());
            e.printStackTrace();
            throw new SistemaMultasException();
        }
    }

    public static void delete(Cadastro cadastro) throws SistemaMultasException{
        String  sql = "DELETE FROM " + cadastro.getNomeTabela() + " WHERE id = " + cadastro.getId();

        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        }catch (SQLIntegrityConstraintViolationException e) {
            Logger.log(e.getMessage());
            throw new SistemaMultasException("Este item está vinculado a outros registros e não pode ser removido!");
        }catch(Exception e){
            e.printStackTrace();
            Logger.log(e.getMessage());
            throw new SistemaMultasException();
        }
    }

    public static Cadastro getById(Cadastro cadastro, Integer id) throws SistemaMultasException{
        String  sql = "SELECT * FROM " + cadastro.getNomeTabela() + " WHERE id = " + id + " LIMIT 1";

        try{
            Statement st = conexao.createStatement();

            ResultSet rs = st.executeQuery(sql);

            List lista = cadastro.resultSetToList(rs);

            if(lista.size() == 0){
                return null;
            }

            return (Cadastro)lista.get(0);

        }catch(Exception e1){
            e1.printStackTrace();
            Logger.log(e1.getMessage());
            throw new SistemaMultasException();
        }
    }
}