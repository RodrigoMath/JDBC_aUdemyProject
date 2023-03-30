package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {

	public static void main(String[] args) throws SQLException {

		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe o nome: ");
		String name = entrada.nextLine();

		Connection conexao = FabricaDeImport.getConnection();
		String sql = " INSERT INTO pessoas (name) values (?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.execute();

		System.out.println("Pessoa incluída com sucesso!");
		entrada.close();
		stmt.close();
	}
}
