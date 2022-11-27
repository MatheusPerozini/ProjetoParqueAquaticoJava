package CTR;

import java.sql.*;

/**
 * Classe para operações CRUD básicas para CTR
 */
public interface BasicCTR<T> {

    /**
     * Função para inserir dados no banco
     *
     * @param t objeto que sera gravado no banco de dados
     * @return retorna mensagem para mostrar ao usuário
     */
    public String inserir(T t);

    /**
     * Função para consultar dados no banco
     *
     * @param t objeto que sera consultado no banco de dados
     * @param opcao opcao para consultar no banco, podendo ser todos da tabela
     * ou um em específico
     * @return retorna os dados do banco de dados consultados
     */
    public ResultSet consultar(T t, int opcao);

    /**
     * Função para alterar dados no banco
     *
     * @param Objeto que sera gravado no banco de dados
     * @return retorna mensagem para mostrar ao usuário
     */
    public String alterar(T t);

    /**
     * Função para deletar dados no banco
     *
     * @param Objeto que sera deletado no banco de dados
     * @return retorna mensagem para mostrar ao usuário
     */
    public String deletar(T t);

    /**
     * Função para fechar comunicação com banco de dados
     */
    public void CloseDB();
}
