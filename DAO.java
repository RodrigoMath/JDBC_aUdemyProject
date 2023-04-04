package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;

public class DAO {
	private Connection conexao;

	public int incluir(String sql, Object... atributos) {
		try {
			PreparedStatement stmt = (PreparedStatement) getConexao().prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			if (stmt.executeUpdate() > 0) {
				ResultSet resultado = stmt.getGeneratedKeys();
				if(resultado.next()) {
					return resultado.getInt(1);
				}
			}
			return -1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	private void adicionarAtributos(PreparedStatement stmt, Object[] atributos) throws SQLException {
		int indice = 1;
		for (Object atributo : atributos) {
			if (atributo instanceof String) {
				stmt.setString(indice, (String) atributo);
			} else if (atributo instanceof Integer) {
				stmt.setInt(indice, (Integer) indice);
			}
			indice++;
		}
	}

	@SuppressWarnings("unused")
	private Connection getConexao() {
		try {
			if (conexao != null && !conexao.isClosed()) {
				return conexao;
			}
		} catch (SQLException e) {

		}
		conexao = (Connection) FabricaDeImport.getConnection();
		return conexao;
	}

}
