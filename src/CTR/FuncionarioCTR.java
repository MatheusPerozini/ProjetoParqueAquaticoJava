package CTR;

import DAO.ConexaoDAO;
import java.sql.ResultSet;
import DTO.FuncionarioDTO;
import DAO.FuncionarioDAO;

/**
 * Classe para operações com a DAO oara funcionarios
 */
public class FuncionarioCTR implements BasicCTR<FuncionarioDTO> {

    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    /**
     * Função para inserir dados no banco
     *
     * @param t objeto que sera gravado no banco de dados
     * @return retorna mensagem para mostrar ao usuário
     */
    @Override
    public String inserir(FuncionarioDTO t) {
        try {
            if (funcionarioDAO.inserir(t)) {
                return "Funcionario cadastrado";
            }
            return "Funcionario não cadastrado";
        } catch (Exception err) {
            System.out.println("Erro FuncionarioCTR.inserir: " + err.getMessage());
            return "Funcionario não cadastrado";
        }
    }

    /**
     * Função para consultar dados no banco
     *
     * @param t objeto que sera consultado no banco de dados
     * @param opcao opcao para consultar no banco, podendo ser todos da tabela
     * ou um em específico
     * @return retorna os dados do banco de dados consultados
     */
    @Override
    public ResultSet consultar(FuncionarioDTO t, int opcao) {
        ResultSet rs = funcionarioDAO.consultar(t, opcao);
        return rs;
    }

    /**
     * Função para alterar dados no banco
     *
     * @param Objeto que sera gravado no banco de dados
     * @return retorna mensagem para mostrar ao usuário
     */
    @Override
    public String alterar(FuncionarioDTO t) {
        try {
            if (funcionarioDAO.alterar(t)) {
                return "Funcionario alterado";
            }
            return "Funcionario não alterado";
        } catch (Exception err) {
            System.out.println("Erro FuncionarioCTR.inserir: " + err.getMessage());
            return "Funcionario não alterado";
        }
    }

    /**
     * Função para deletar dados no banco
     *
     * @param Objeto que sera deletado no banco de dados
     * @return retorna mensagem para mostrar ao usuário
     */
    @Override
    public String deletar(FuncionarioDTO t) {
        try {
            if (funcionarioDAO.deletar(t)) {
                return "Funcionario deletado";
            }
            return "Funcionario não deletado";
        } catch (Exception err) {
            System.out.println("Erro FuncionarioCTR.inserir: " + err.getMessage());
            return "Funcionario não deletado";
        }
    }

    /**
     * Função para login do Funcionario
     *
     * @param Objeto com os dados do funcionario para autenticas
     * @return retorna o id_funcionario se conseguir
     */
    public int loginFuncionario(FuncionarioDTO t) {
        return funcionarioDAO.loginFuncionario(t);
    }

    /**
     * Função para fechar comunicação com banco de dados
     */
    public void CloseDB() {
        ConexaoDAO.closeDb();
    }

}
