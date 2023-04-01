package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPessoas1 {

	public static void main(String[] args) throws SQLException {
		// consultar todas pessoas no banco.

		Connection conexao = FabricaDeImport.getConnection();
		String sql = "SELECT * from pessoas";

		Statement stmt = conexao.createStatement();
		// execute resulta valor booleano, executeQuerry devolve um result set, para
		// podermos ver.
		ResultSet resultado = stmt.executeQuery(sql);

		List<Pessoa> pessoas = new ArrayList<>();

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
