package DAO;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


/**
 * Classe para gerar hash de senha e validação
 */
public class HashSenhaDAO {
	private static final Random random = new SecureRandom();
	private static final String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final int iterations = 10000;
	private static final int keylength = 256;

	/**
	* Função para gerar uma chave aleatória para poder comparar a senha
	* @param length Tamanho da chave 
	* @return retorna uma chave aleatória
	*/
	public static String getSaltvalue(int length) {
		StringBuilder finalval = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			finalval.append(characters.charAt(random.nextInt(characters.length())));
		}
		return new String(finalval);
	}

	/**
	* Função para gerar o hash da senha
	* @param password Senha para realizar o hash
	* @param salt Onde deve ser inserido a chave aleatória
	* @return retorna o hash da senha
	*/
	public static byte[] hash(char[] password, byte[] salt) {
		PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keylength);
		Arrays.fill(password, Character.MIN_VALUE);
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			return skf.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
		} finally {
			spec.clearPassword();
		}
	}

	/**
	* Função para gerar a senha criptografada
	* @param password Senha para realizar o hash
	* @param salt Onde deve ser inserido a chave aleatória
	* @return retorna a senha criptografada
	*/
	public static String generateSecurePassword(String password, String salt) {
		String finalval = null;
		byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
		finalval = Base64.getEncoder().encodeToString(securePassword);
		return finalval;
	}

	/**
	* Função para verificar a senha criptografada e verificar se são iguais a senha digitada
	* @param providedPassword Senha digitada para verificação
	* @param securedPassword Senha criptografada salva no banco
	* @param salt Chave gerada para comparação
	* @return retorna true se a senha for igual, false se não for
	*/
	public static boolean verifyUserPassword(String providedPassword, String securedPassword, String salt) {
		boolean finalval = false;
		String newSecurePassword = generateSecurePassword(providedPassword, salt);
		finalval = newSecurePassword.equalsIgnoreCase(securedPassword);
		return finalval;
	}
	
}