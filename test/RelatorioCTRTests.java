import static org.junit.jupiter.api.Assertions.*;

import CTR.RelatorioCTR;
import org.junit.jupiter.api.Test;

class RelatorioCTRTests {
	private RelatorioCTR relatorioCTR = new RelatorioCTR();

	@Test
	void retornarNumeroClienteTotais() {
		System.out.println(this.relatorioCTR.retornarNumeroClienteTotais());
	}

	@Test
	void retornarNumeroFuncionarioTotais() {
		System.out.println(this.relatorioCTR.retornarNumeroFuncionarioTotais());
	}

	@Test
	void retornarNumeroDeClientesPorFuncionario() {
		System.out.println(this.relatorioCTR.retornarNumeroDeClientesPorFuncionario(5));
	}

	@Test
	void retornarNumeroDeClientesPorMesEAno() {
		System.out.println(this.relatorioCTR.retornarNumeroDeClientesPorMesEAno(11, 12, 2022));
	}

}
