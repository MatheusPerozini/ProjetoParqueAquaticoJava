package DAO;

import java.sql.ResultSet;

/**
 * Classe para operações CRUD básicas para a DAO 
 */
public interface BasicDAO<T> {
	/**
	* Função para inserir dados no banco
	*
	* @param t objeto que sera gravado no banco de dados
	* @return retorna true se conseguir inserir e false se não conseguir inserir
	*/
	public boolean inserir(T t);

	/**
	* Função para consultar dados no banco
	*
	* @param t objeto que sera consultado no banco de dados
	* @param opcao opcao para consultar no banco, podendo ser todos da tabela ou um em específico
	* @return retorna os dados do banco de dados consultados
	*/
	public ResultSet consultar(T t, int opcao);

	/**
	* Função para alterar dados no banco
	*
	* @param Objeto que sera gravado no banco de dados
	* @return retorna true se conseguir alterar e false se não conseguir alterar
	*/
	public boolean alterar(T t);

	/**
	* Função para deletar dados no banco
	*
	* @param Objeto que sera deletar no banco de dados
	* @return retorna true se conseguir deletar e false se não conseguir deletar
	*/
	public boolean deletar(T t);
}
