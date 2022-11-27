import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import DTO.FuncionarioDTO;
import CTR.FuncionarioCTR;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioCTRTests {
	private FuncionarioCTR funcionarioCTR = new FuncionarioCTR();

	@Test
	void inserir() {
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		funcionarioDTO.setCpf("88945423305");
		funcionarioDTO.setData_nascimento(new Date());
		funcionarioDTO.setNome("Teste");
		funcionarioDTO.setSenha("asdf");
		System.out.println(funcionarioCTR.inserir(funcionarioDTO));
	}
	
	@Test
	void logar() {
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		funcionarioDTO.setCpf("78945412305");
		funcionarioDTO.setSenha("asdf");
		System.out.println(funcionarioCTR.loginFuncionario(funcionarioDTO));
	}
	
	@Test
	void alterar() {
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		funcionarioDTO.setCpf("78945612305");
		funcionarioDTO.setData_nascimento(new Date());
		funcionarioDTO.setId_funcionario(1);
		funcionarioDTO.setNome("Teasdfasffdfste");
		funcionarioDTO.setSenha("asdf");
		System.out.println(funcionarioCTR.alterar(funcionarioDTO));
	}

	@Test
	void consultar() {
		ResultSet rs = funcionarioCTR.consultar(null, 1);
		try {
			while(rs.next()) {
				System.out.println(rs.getString("nome"));
			}
		} catch (SQLException e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	void deletar() {
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		funcionarioDTO.setId_funcionario(1);
		System.out.println(funcionarioCTR.deletar(funcionarioDTO));
	}

}
