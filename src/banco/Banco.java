package banco;

import commons.utils.Utils;
import commons.cadastros.Cadastro;

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
                e1.printStackTrace();
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
                e1.printStackTrace();
            }
        }
    }

    public static void save(Cadastro cadastro){
        String sql;

        boolean isNovo = cadastro.isNovo();

        if(isNovo){
            sql = "INSERT INTO " + cadastro.getNomeTabela() + "(" + cadastro.getColunas() + ") VALUES(" + cadastro.getColunasSubstituicao() + ")";
        }else{
            sql = "UPDATE " + cadastro.getNomeTabela() + " SET " +  cadastro.getColunas().replaceAll(",", " = ?, ") + " = ? WHERE id = " + cadastro.getId();
        }

        try{
            PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            cadastro.setStatements(stmt);
            stmt.execute();

            if (cadastro.isNovo()   ){
                ResultSet resultSet = stmt.executeQuery("SELECT LAST_INSERT_ID()");
                if (resultSet.next()) {
                    cadastro.setId(resultSet.getInt("LAST_INSERT_ID()"));
                }
            }
            stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static List select(Cadastro cadastro){
        //TODO: melhorar a maneira de ordenção
        return selectComWhere(cadastro, "ORDER BY tipo ASC");
    }

    public static List selectComWhere(Cadastro cadastro, String where){
        String  sql = "SELECT * FROM " + cadastro.getNomeTabela() + (Utils.isNulaOuVazia(where) ? "" : " " + where);

        try{
            Statement st = conexao.createStatement();

            ResultSet rs = st.executeQuery(sql);

            return cadastro.resultSetToList(rs);

        }catch(Exception e){
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public static void delete(Cadastro cadastro){
        String  sql = "DELETE FROM " + cadastro.getNomeTabela() + " WHERE id = " + cadastro.getId();

        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}