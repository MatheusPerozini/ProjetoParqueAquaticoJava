import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import DTO.ClienteDTO;
import CTR.ClienteCTR;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

class ClienteCTRTests {
	private ClienteCTR clienteCTR = new ClienteCTR();

	@Test
	void inserir() {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setCpf("38573678883");
		clienteDTO.setEmail("teste@gmail.com");
		clienteDTO.setId_funcionario(5);
		Date dataNascimento = new Date(2001 - 1901, 12, 25);
		clienteDTO.setData_nascimento(dataNascimento);
		clienteDTO.setNome("Testaae");
		clienteDTO.setTelefone("11966175842");
		System.out.println(clienteCTR.inserir(clienteDTO));
	}

	@Test
	void alterar() {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId_cliente(1);
		clienteDTO.setCpf("38243178893");
		clienteDTO.setEmail("teste@gmail.com");
		clienteDTO.setId_funcionario(1);
		Date dataNascimento = new Date(2001 - 1901, 12, 25);
		clienteDTO.setData_nascimento(dataNascimento);
		clienteDTO.setNome("Tesasdfadfsafsfate");
		clienteDTO.setTelefone("11966175842");
		System.out.println(clienteCTR.alterar(clienteDTO));
	}

	@Test
	void consultar() {
		ResultSet rs = this.clienteCTR.consultar(null, 1);
		try {
			while (rs.next()) {
				System.out.println(rs.getString("nome"));
			}
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}

	@Test
	void deletar() {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId_cliente(1);
		clienteDTO.setCpf("38243178893");
		clienteDTO.setEmail("teste@gmail.com");
		clienteDTO.setId_funcionario(1);
		clienteDTO.setData_nascimento(null);
		clienteDTO.setNome("Teste");
		clienteDTO.setTelefone("11966175842");
		System.out.println(clienteCTR.deletar(clienteDTO));
	}

}
