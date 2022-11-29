package DAO;

import java.sql.*;
import java.text.SimpleDateFormat;
import DTO.FuncionarioDTO;
import DAO.HashSenhaDAO;

/**
 * Classe para operações diretas com o banco de dados oara Funcioario
 */
public class FuncionarioDAO implements BasicDAO<FuncionarioDTO> {

    private ResultSet rs = null;
    private Statement stmt = null;
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    private final String senheSaltValue = "pTWkHShuY6";

    /**
     * Função para inserir dados no banco
     *
     * @param funcionario objeto que sera gravado no banco de dados
     * @return retorna true se conseguir inserir e false se não conseguir
     * inserir
     */
    public boolean inserir(FuncionarioDTO funcionario) {
        try {
            ConexaoDAO.conectDb();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "insert into funcionario (nome, cpf, data_nascimento, senha) values " + "('"
                    + funcionario.getNome() + "'" + "," + "'" + funcionario.getCpf() + "'" + ", " + "to_date('"
                    + date.format(funcionario.getData_nascimento()) + "', 'dd/mm/yyyy'), " + "'"
                    + HashSenhaDAO.generateSecurePassword(funcionario.getSenha(), senheSaltValue) + "'" + " )";
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception err) {
            System.out.println("Erro FuncionarioDAO.inserir: " + err.getMessage());
            return false;
        } finally {
            ConexaoDAO.closeDb();
        }
    }

    /**
     * Função para login do Funcionario
     *
     * @param funcionario objeto com os dados do funcionario para autenticas
     * @return retorna o id do funcionario
     */
    public int loginFuncionario(FuncionarioDTO funcionario) {
        int id_funcionario = 0;
        try {
            boolean resultado = false;
            ConexaoDAO.conectDb();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "select id_funcionario, cpf, senha from funcionario where cpf = " + "'" + funcionario.getCpf() + "';";
            rs = stmt.executeQuery(comando.toUpperCase());
            while (rs.next()) {
                if (rs.getString("cpf").equals(funcionario.getCpf())) {
                    if (HashSenhaDAO.verifyUserPassword(funcionario.getSenha(), rs.getString("senha"),
                            this.senheSaltValue)) {
                        id_funcionario = Integer.parseInt(rs.getString("id_funcionario"));
                    }
                }
            }
            return id_funcionario;
        } catch (Exception err) {
            System.out.println("Erro FuncionarioDAO.loginFuncionario: " + err.getMessage());
            return id_funcionario;
        } finally {
            ConexaoDAO.closeDb();
        }
    }

    /**
     * Função para alterar dados no banco
     *
     * @param funcionario Objeto que sera gravado no banco de dados
     * @return retorna true se conseguir alterar e false se não conseguir
     * alterar
     */
    public boolean alterar(FuncionarioDTO funcionario) {
        try {
            ConexaoDAO.conectDb();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "update funcionario set " + "nome = " + "'" + funcionario.getNome() + "'" + ", "
                    + "data_nascimento = " + "'" + date.format(funcionario.getData_nascimento()) + "'" + ", "
                    + "senha = " + "'" + HashSenhaDAO.generateSecurePassword(funcionario.getSenha(), senheSaltValue)
                    + "' where id_funcionario = " + funcionario.getId_funcionario();
            if (funcionario.getSenha() == null || funcionario.getSenha().isEmpty()) {
                comando = "update funcionario set " + "nome = " + "'" + funcionario.getNome() + "'" + ", "
                        + "data_nascimento = " + "'" + date.format(funcionario.getData_nascimento())
                        + "' where id_funcionario = " + funcionario.getId_funcionario();
            }
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception err) {
            System.out.println("Erro FuncionarioDAO.alterar: " + err.getMessage());
            return false;
        } finally {
            ConexaoDAO.closeDb();
        }
    }

    /**
     * Função para consultar dados no banco
     *
     * @param t objeto que sera consultado no banco de dados
     * @param opcao opcao para consultar no banco, podendo ser todos da tabela
     * ou um em específico
     * @return retorna true se conseguir consultar e false se não conseguir
     * consultar
     */
    public ResultSet consultar(FuncionarioDTO t, int opcao) {
        try {
            ConexaoDAO.conectDb();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "select f.* from funcionario f "
                            + "where nome ilike '" + t.getNome() + "%' "
                            + "order by f.nome";
                    break;
                case 2:
                    comando = "select f.* from funcionario f "
                            + "where f.id_funcionario = " + t.getId_funcionario();
                    break;
                case 3:
                    comando = "select f.id_funcionario, f.nome from funcionario f";
                    break;
            }
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } catch (Exception err) {
            System.out.println("Erro FuncionarioDAO.consultar: " + err.getMessage());
            return rs;
        }
    }

    /**
     * Função para deletar dados no banco
     *
     * @param funcionario Objeto que sera deletar no banco de dados
     * @return retorna true se conseguir deletar e false se não conseguir
     * deletar
     */
    public boolean deletar(FuncionarioDTO funcionario) {
        try {
            ConexaoDAO.conectDb();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "delete from funcionario where id_funcionario = " + funcionario.getId_funcionario();
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception err) {
            System.out.println("Erro FuncionarioDAO.deletar: " + err.getMessage());
            return false;
        } finally {
            ConexaoDAO.closeDb();
        }
    }

}
