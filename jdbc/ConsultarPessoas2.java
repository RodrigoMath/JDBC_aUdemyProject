package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas2 {
	public static void main(String[] args) throws SQLException {
		// consultar pessoas com base nas letras do nome.

		Scanner leitor = new Scanner(System.in);

		System.out
				.println("Você possuí três opções de pesquisa de nome de usuário: " + "[1] Para iniciais. Ex.: PE(dro)"
						+ "[2] Para terminação. Ex.:(pe)DRO" + "[3] Ambas." + "Digite o número da opção desejada:");
		int escolha = leitor.nextInt();
		leitor.nextLine();
		System.out.println("Por favor, agora informe as sílabas que o sistema deve procurar:");
		
		String silabas = leitor.nextLine();

		Connection conexao = FabricaDeImport.getConnection();

		if (escolha == 1) {
			String sql = "SELECT * FROM pessoas WHERE name LIKE ?";
			PreparedStatement stmt= conexao.prepareStatement(sql);
			stmt.setString(1,silabas + "%");
			ResultSet resultado = stmt.executeQuery();
			List<Pessoa> pessoas = new ArrayList<>();
			possiblePrints(resultado, pessoas);

		}

	}

	private static void possiblePrints(ResultSet resultado, List<Pessoa> pessoas) throws SQLException {
		while (resultado.next()) {
			int code = resultado.getInt("code");
			String name = resultado.getString("name");
			pessoas.add(new Pessoa(code, name));
		}
		for (Pessoa pessoa : pessoas) {
			System.out.println("Código: " + pessoa.getCode() + ", usuário:" + pessoa.getName() + ".");
			System.out.println(" ");
		}
	}

}
