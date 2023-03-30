package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class UpdatePessoa {
	public static void main(String[] args) throws SQLException {
		
			Scanner leitor = new Scanner(System.in);
			Connection conexao = FabricaDeImport.getConnection();
			
			System.out.println("Digite o código do nome do usuário que deseja alterar:");
			int codeChange = leitor.nextInt();
			leitor.nextLine();
			
			
			String sql = "update pessoas set name =(?) where code=" + codeChange + ";";
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
			
			System.out.println("Digite o novo nome que deseja corresponder a esse código:");
			String newName = leitor.nextLine();
			
			stmt.setString(1, newName);
			stmt.execute();
			
			System.out.println("Pronto, agora o código:"+ codeChange + ", está com o nome de:");
			String sql2="SELECT * from pessoas where code='"+ codeChange+"';";
			// para trazer a informação
			ResultSet resultado =stmt.executeQuery(sql2);
		
	}

}
