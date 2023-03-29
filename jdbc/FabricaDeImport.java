package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class FabricaDeImport  {
	
	
	
	// Criando uma chamada rápida para a conexão.
	public static Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/curso_java?verifyServerCertificate=false&useSSL=true";
			String usuario = "root";
			String senha ="06031998Rr@";
			return DriverManager.getConnection(url, usuario , senha);
		} catch (SQLException e) {
			 throw new RuntimeException(e);
		}
		
		
				
	}

}
