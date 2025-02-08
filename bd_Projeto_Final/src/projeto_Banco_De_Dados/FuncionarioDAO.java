package projeto_Banco_De_Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioDAO {
	
	public void inserirFuncionario(List<Funcionario> funcAtributos) {
		
		String sql = "INSERT INTO funcionario (Cpf_func, Nome_func, Tele_func, Idade_func) VALUES (?, ?, ?, ?)";
		
		try(Connection conexao = ConectarBD.conectarBancoDeDados();
				 PreparedStatement stmt = conexao.prepareStatement(sql)){
			
			for(Funcionario f : funcAtributos) {
				stmt.setString(1, f.getCpf());
				stmt.setString(2, f.getNome());
				stmt.setString(3, f.getTelefone());
				stmt.setInt(4, f.getIdade());
				
				stmt.addBatch();
			}
			
			stmt.executeBatch();
	        System.out.println("Funcionario inserido com sucesso!");
	         
		}catch(SQLException | ClassNotFoundException e) {
			 e.printStackTrace();
		 }
	}

	public void selecionaPorSubString(String substring) {
		
		String sql = "SELECT * FROM funcionario WHERE Nome_Func ILIKE ?";
		
		try (Connection conexao = ConectarBD.conectarBancoDeDados();
		         PreparedStatement stmt = conexao.prepareStatement(sql)){
			
			stmt.setString(1, "%" + substring + "%");
			
			 try (ResultSet rset = stmt.executeQuery()){
				 
				 while(rset.next()) {
					 
					 int id = rset.getInt("Id_func");
		             String cpf = rset.getString("Cpf_func");
		             String nome = rset.getString("Nome_func");
		             String telefone = rset.getString("Tele_func");
		             int idade = rset.getInt("Idade_func");

		             System.out.printf(
		            		    "Id_func: %-2d | Cpf_func: %-11s | Nome_func: %-15s | Tele_func: %-9s | Idade_func: %-3d%n",
		            		    id, cpf, nome, telefone, idade
		            		);
				 }
			 }
			
		} catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
		
	}
}
