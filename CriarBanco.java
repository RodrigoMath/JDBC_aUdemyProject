package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
	public static void main(String[] args) throws SQLException {

		Connection conexao = FabricaDeImport.getConnection();
		Statement stmt = conexao.createStatement();
		stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java");

		String sql = "CREATE TABLE IF NOT EXISTS pessoas(" + "code INT AUTO_INCREMENT PRIMARY KEY,"
				+ "name VARCHAR(80) NOT NULL" + ")";
		stmt.execute(sql);

		System.out.println("Tabela criada com sucesso!");
		stmt.close();

	}

}
