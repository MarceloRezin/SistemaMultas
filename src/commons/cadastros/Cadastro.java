package commons.cadastros;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class Cadastro {

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isNovo(){
	    return id == null;
    }

    /**
     * Utilizado no list da tela de listagem
     * @return
     */
	public abstract String toString();

	/**
	 * Retorna o nome da tabela utilizada no banco
	 * @return
	 */
	public abstract String getNomeTabela();

	/**
	 * Retorna todas as colunas que serão gravadas no insert com o padrão: coluna1,coluna2,coluna3
     * Não é necessário informar o id
	 * @return
	 */
	public abstract String getColunas();

	/**
	 * Retorna a substituicao das colunas por ?,?,?
	 * @return
	 */
	public String getColunasSubstituicao(){
		String[] lista = getColunas().split(",");

		String result = "";

		for(int i=0; i<lista.length; i++){
			if(i == lista.length -1){
				result += "?";
			}else{
				result += "?,";
			}
		}

		return result;
	}

    /**
     * Define os valores que serao inseridos nas colunas
     * @param stmt
     * @throws SQLException
     */
	public abstract void setStatements(PreparedStatement stmt) throws SQLException;

    /**
     * Converte result da consulta em uma lista de objetos
     * @param rs
     * @return
     * @throws SQLException
     */
	public abstract List resultSetToList(ResultSet rs) throws SQLException;

	/**
	 * Define qual coluna será utlizada para ordenar o itens apresentados na tela
	 * @return
	 */
	public abstract String getColunaOrdenacao();

	/**
	 * Retorna qual coluna da tabela deve ser utilizada para pesquisa, por padrão é a mesma coluna da ordenação
	 * @return
	 */
	public String getColunaPesquisa(){
		return getColunaOrdenacao();
	}
}
