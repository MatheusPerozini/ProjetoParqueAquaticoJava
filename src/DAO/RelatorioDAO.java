package DAO;

import DAO.ConexaoDAO;
import java.sql.*;

/**
 * Classe para operações diretas com o banco de dados oara gerar relatório
 */
public class RelatorioDAO {
	private ResultSet rs = null;
	private Statement stmt = null;

	/**
	* Função para retornar o numero de clientes no banco
	* @return retorna o numero de clientes
	*/
	public int retornarNumeroClienteTotais() {
		int numeroDeClientes = 0;
		try {
			ConexaoDAO.conectDb();
			stmt = ConexaoDAO.con.createStatement();
			String comando = "select count(*) from cliente;";
			rs = stmt.executeQuery(comando.toUpperCase());
			while (rs.next()) {
				numeroDeClientes = Integer.parseInt(rs.getString("count"));
			}
			return numeroDeClientes;
		} catch (Exception err) {
			System.out.println("Erro RelatorioDAO.retornarNumeroClienteTotais: " + err.getMessage());
			return numeroDeClientes;
		} finally {
			ConexaoDAO.closeDb();
		}
	}

	/**
	* Função para retornar o numero de funcionarios no banco
	* @return retorna numero de funcionarios
	*/
	public int retornarNumeroFuncionarioTotais() {
		int numeroDeClientes = 0;
		try {
			ConexaoDAO.conectDb();
			stmt = ConexaoDAO.con.createStatement();
			String comando = "select count(*) from funcionario;";
			rs = stmt.executeQuery(comando.toUpperCase());
			while (rs.next()) {
				numeroDeClientes = Integer.parseInt(rs.getString("count"));
			}
			return numeroDeClientes;
		} catch (Exception err) {
			System.out.println("Erro RelatorioDAO.retornarNumeroFuncionarioTotais: " + err.getMessage());
			return numeroDeClientes;
		} finally {
			ConexaoDAO.closeDb();
		}
	}

	/**
	* Função para retornar numero de clientes no banco por funcionario
	* @param id_funcionario Id funcionario para buscar seus clientes vinculados
	* @return retorna numero de clientes vinculado por funcionario
	*/
	public int retornarNumeroDeClientesPorFuncionario(int id_funcionario) {
		int numeroDeClientes = 0;
		try {
			ConexaoDAO.conectDb();
			stmt = ConexaoDAO.con.createStatement();
			String comando = "select count(id_funcionario) as numerodeclientedofuncionario, id_funcionario "
					+ "from cliente where id_funcionario = " + id_funcionario + " group by id_funcionario";
			rs = stmt.executeQuery(comando.toUpperCase());
			while (rs.next()) {
				numeroDeClientes = Integer.parseInt(rs.getString("numerodeclientedofuncionario"));
			}
			return numeroDeClientes;
		} catch (Exception err) {
			System.out.println("Erro RelatorioDAO.retornarNumeroDeClientesPorFuncionario: " + err.getMessage());
			return numeroDeClientes;
		} finally {
			ConexaoDAO.closeDb();
		}
	}

	/**
	* Função para retornar numero de clientes no banco por data
	* @param mes_inicio mes de inicio da pesquisa
	* @param mes_fim mes de fim da pesquisa
	* @param ano Ano para pesquisar
	* @return retorna numero de clientes vinculado por data
	*/
	public int retornarNumeroDeClientesPorMesEAno(int mes_inicio, int mes_fim, int ano) {
		int numeroDeClientes = 0;
		try {
			ConexaoDAO.conectDb();
			stmt = ConexaoDAO.con.createStatement();
			String comando = "select count(*) from cliente where data_criacao between '1-" + mes_inicio + "-" + ano
					+ "' and " + " '30-" + mes_fim + "-" + ano + "'";
                        System.out.println("inicio " + mes_inicio + " fim " + mes_fim + " ano " + ano);
			rs = stmt.executeQuery(comando.toUpperCase());
			while (rs.next()) {
                                System.out.println("DAO.RelatorioDAO.retornarNumeroDeClientesPorMesEAno(): " + rs.getString("count"));
				numeroDeClientes = Integer.parseInt(rs.getString("count"));
			}
			return numeroDeClientes;
		} catch (Exception err) {
			System.out.println("Erro RelatorioDAO.retornarNumeroDeClientesPorMesEAno: " + err.getMessage());
			return numeroDeClientes;
		} finally {
			ConexaoDAO.closeDb();
		}
	}

}
