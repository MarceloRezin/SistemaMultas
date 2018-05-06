package banco;

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

        if(cadastro.isNovo()){
            sql = "INSERT INTO " + cadastro.getNomeTabela() + "(" + cadastro.getColunas() + ") VALUES(" + cadastro.getColunasSubstituicao() + ")";
        }else{
            sql = "UPDATE " + cadastro.getNomeTabela() + " SET " +  cadastro.getColunas().replaceAll(",", " = ?, ") + " = ? WHERE id = " + cadastro.getId();
        }

        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            cadastro.setStatements(stmt);
            stmt.execute();
            stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static List select(Cadastro cadastro){
        String  sql = "SELECT * FROM " + cadastro.getNomeTabela();

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