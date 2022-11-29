package DAO;

import java.sql.*;

/**
 * Classe para conectar ao banco de dados
 */
public class ConexaoDAO {
	public static Connection con = null;

	/**
	* Função para conectar ao banco de dados
	*/
	public static void conectDb() {
		try {
			String dsn = "ProjetoParqueAquatico";
			String user = "postgres";
			String senha = "postdba";

			DriverManager.registerDriver(new org.postgresql.Driver());

			String url = "jdbc:postgresql://localhost:5432/" + dsn;

			con = DriverManager.getConnection(url, user, senha);

			con.setAutoCommit(false);
			if (con == null) {
				System.out.println("Erro ao abrir o banco");
			}
		} catch (Exception err) {
			System.out.println("Erro ConexaoDAO.conectDb(): " + err.getMessage());
		}
	}

	
	/**
	* Função para fechar a conexão ao banco de dados
	*/
	public static void closeDb() {
		try {
			con.close();
		} catch (Exception err) {
			System.out.println("Erro ConexaoDAO.closeDb(): " + err.getMessage());
		}
	}
}
