package CTR;

import DAO.ConexaoDAO;
import DAO.RelatorioDAO;

/**
 * Classe para operações com a DAO oara relatórios
 */
public class RelatorioCTR {

    private RelatorioDAO relatorioDAO = new RelatorioDAO();

    /**
     * Função para retornar o numero de clientes no banco
     *
     * @return retorna o numero de clientes
     */
    public int retornarNumeroClienteTotais() {
        try {
            return relatorioDAO.retornarNumeroClienteTotais();
        } catch (Exception err) {
            System.out.println("Erro RelatorioDAO.retornarNumeroClienteTotais: " + err.getMessage());
            return 0;
        }
    }

    /**
     * Função para retornar o numero de funcionarios no banco
     *
     * @return retorna numero de funcionarios
     */
    public int retornarNumeroFuncionarioTotais() {
        try {
            return relatorioDAO.retornarNumeroFuncionarioTotais();
        } catch (Exception err) {
            System.out.println("Erro RelatorioDAO.retornarNumeroClienteTotais: " + err.getMessage());
            return 0;
        }
    }

    /**
     * Função para retornar numero de clientes no banco por funcionario
     *
     * @param id_funcionario Id funcionario para buscar seus clientes vinculados
     * @return retorna numero de clientes vinculado por funcionario
     */
    public int retornarNumeroDeClientesPorFuncionario(int id_funcionario) {
        try {
            return relatorioDAO.retornarNumeroDeClientesPorFuncionario(id_funcionario);
        } catch (Exception err) {
            System.out.println("Erro RelatorioDAO.retornarNumeroClienteTotais: " + err.getMessage());
            return 0;
        }
    }

    /**
     * Função para retornar numero de clientes no banco por data
     *
     * @param mes_inicio mes de inicio da pesquisa
     * @param mes_fim mes de fim da pesquisa
     * @param ano Ano para pesquisar
     * @return retorna numero de clientes vinculado por data
     */
    public int retornarNumeroDeClientesPorMesEAno(int mes_inicio, int mes_fim, int ano) {
        try {
            return relatorioDAO.retornarNumeroDeClientesPorMesEAno(mes_inicio, mes_fim, ano);
        } catch (Exception err) {
            System.out.println("Erro RelatorioDAO.retornarNumeroClienteTotais: " + err.getMessage());
            return 0;
        }
    }

    /**
     * Função para fechar comunicação com banco de dados
     */
    public void CloseDB() {
        ConexaoDAO.closeDb();
    }
}
