package CTR;

import java.sql.ResultSet;
import DAO.ClienteDAO;
import DAO.ConexaoDAO;
import DTO.ClienteDTO;

/**
 * Classe para operações com a DAO oara cliente
 */
public class ClienteCTR implements BasicCTR<ClienteDTO> {
	private ClienteDAO clienteDAO = new ClienteDAO();

	/**
	* Função para inserir dados no banco
	*
	* @param t objeto que sera gravado no banco de dados
	* @return retorna mensagem para mostrar ao usuário
	*/
	@Override
	public String inserir(ClienteDTO t) {
		try {
			if (clienteDAO.inserir(t)) {
				return "Cliente inserido";
			}
			return "Cliente não inserido";
		} catch (Exception err) {
			System.out.println("Erro ClienteCTR.inserir: " + err.getMessage());
			return "Cliente não inserido";
		}
	}

	/**
	* Função para consultar dados no banco
	*
	* @param t objeto que sera consultado no banco de dados
	* @param opcao opcao para consultar no banco, podendo ser todos da tabela ou um em específico
	* @return retorna os dados do banco de dados consultados
	*/
	@Override
	public ResultSet consultar(ClienteDTO t, int opcao) {
		ResultSet rs = clienteDAO.consultar(t, opcao);
		return rs;
	}

	/**
	* Função para alterar dados no banco
	*
	* @param Objeto que sera gravado no banco de dados
	* @return retorna mensagem para mostrar ao usuário
	*/
	@Override
	public String alterar(ClienteDTO t) {
		try {
			if (clienteDAO.alterar(t)) {
				return "Cliente alterado";
			}
			return "Cliente não alterado";
		} catch (Exception err) {
			System.out.println("Erro ClienteCTR.inserir: " + err.getMessage());
			return "Cliente não alterado";
		}
	}

	/**
	* Função para deletar dados no banco
	*
	* @param Objeto que sera deletar no banco de dados
	* @return retorna mensagem para mostrar ao usuário
	*/
	@Override
	public String deletar(ClienteDTO t) {
		try {
			if (clienteDAO.deletar(t)) {
				return "Cliente deletado";
			}
			return "Cliente não deletado";
		} catch (Exception err) {
			System.out.println("Erro ClienteCTR.inserir: " + err.getMessage());
			return "Cliente não deletado";
		}
	}

        /**
	* Função para fechar comunicação com banco de dados
	*/
        public void CloseDB() {
            ConexaoDAO.closeDb();
        }
        
}
