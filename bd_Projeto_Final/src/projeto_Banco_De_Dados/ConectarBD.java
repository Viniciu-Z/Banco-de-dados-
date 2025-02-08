package projeto_Banco_De_Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConectarBD {
	
	private static final String USERNAME = "postgres";
	
	private static final String PASSWORD = "20112003";
	
	private static final String URL = "jdbc:postgresql://localhost:5432/Trabalho_Final";
	
	public static Connection conectarBancoDeDados() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		
		Connection conectar = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		return conectar;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conexao = conectarBancoDeDados();

		if(conexao != null) {
			System.out.println("Conectado ao banco de dados");
			conexao.close();
		}
	}
}
