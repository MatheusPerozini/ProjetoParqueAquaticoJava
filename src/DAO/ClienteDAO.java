package DAO;

import java.sql.*;
import java.text.SimpleDateFormat;
import DTO.ClienteDTO;
import DTO.FuncionarioDTO;

/**
 * Classe para operações diretas com o banco de dados oara Cliente
 */
public class ClienteDAO implements BasicDAO<ClienteDTO> {

    private ResultSet rs = null;
    private Statement stmt = null;
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Função para inserir dados no banco
     *
     * @param clienteDTO objeto que sera gravado no banco de dados
     * @return retorna true se conseguir inserir e false se não conseguir
     * inserir
     */
    public boolean inserir(ClienteDTO clienteDTO) {
        try {
            ConexaoDAO.conectDb();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "insert into cliente "
                    + "(nome, cpf, email, telefone, data_nascimento, id_funcionario) values (" + "'"
                    + clienteDTO.getNome() + "'" + ", " + "'" + clienteDTO.getCpf() + "'" + ", " + "'"
                    + clienteDTO.getEmail() + "'" + ", " + "'" + clienteDTO.getTelefone() + "'" + ", " + "'"
                    + date.format(clienteDTO.getData_nascimento()) + "'" + ", " + clienteDTO.getId_funcionario() + ")";
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ClienteDAO.inserir: " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.closeDb();
        }
    }

    /**
     * Função para consultar dados no banco
     *
     * @param clienteDTO objeto que sera consultado no banco de dados
     * @param opcao opcao para consultar no banco, podendo ser todos da tabela
     * ou um em específico
     * @return retorna true se conseguir consultar e false se não conseguir
     * consultar
     */
    public ResultSet consultar(ClienteDTO clienteDTO, int opcao) {
        try {
            ConexaoDAO.conectDb();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "select c.* from cliente c "
                            + "where nome ilike '" + clienteDTO.getNome() + "%' "
                            + "order by c.nome";
                    break;
                case 2:
                    comando = "select c.* from cliente c "
                            + "where c.id_cliente = " + clienteDTO.getId_cliente();
                    break;
                case 3:
                    comando = "select c.id_cliente, c.nome from cliente c";
                    break;
            }
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } catch (Exception e) {
            System.out.println("Erro ClienteDAO.consultar: " + e.getMessage());
            return rs;
        }
    }

    /**
     * Função para alterar dados no banco
     *
     * @param clienteDTO Objeto que sera gravado no banco de dados
     * @return retorna true se conseguir alterar e false se não conseguir
     * alterar
     */
    public boolean alterar(ClienteDTO clienteDTO) {
        try {
            ConexaoDAO.conectDb();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Update cliente set " + "nome = " + "'" + clienteDTO.getNome() + "'" + ", " + "telefone = "
                    + "'" + clienteDTO.getTelefone() + "'" + ", " + "email =" + "'" + clienteDTO.getEmail() + "'" + ", "
                    + "data_nascimento = " + "'" + date.format(clienteDTO.getData_nascimento()) + "' "
                    + "where id_cliente = " + clienteDTO.getId_cliente();
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ClienteDAO.alterar: " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.closeDb();
        }
    }

    /**
     * Função para deletar dados no banco
     *
     * @param clienteDTO Objeto que sera deletar no banco de dados
     * @return retorna true se conseguir deletar e false se não conseguir
     * deletar
     */
    public boolean deletar(ClienteDTO clienteDTO) {
        try {
            ConexaoDAO.conectDb();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "delete from cliente where id_cliente = " + clienteDTO.getId_cliente();
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ClienteDAO.deletar: " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.closeDb();
        }
    }

}
