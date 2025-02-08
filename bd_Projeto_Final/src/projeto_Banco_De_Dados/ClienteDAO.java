package projeto_Banco_De_Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClienteDAO {
	
	public void inserirCliente(String nome, String cpf, String nacionalidade, int idade) {
		
		String sql;
		
		if (nacionalidade == null) {
	        sql = "INSERT INTO cliente (Nome_cliente, Cpf_cliente, Idade_cliente) VALUES (?, ?, ?)";
	    } else {
	        sql = "INSERT INTO cliente (Nome_cliente, Cpf_cliente, Nacionalidade, Idade_cliente) VALUES (?, ?, ?, ?)";
	    }
		
		 try(Connection conexao = ConectarBD.conectarBancoDeDados();
				 PreparedStatement stmt = conexao.prepareStatement(sql)){
			 
			 stmt.setString(1, nome);
			 stmt.setString(2, cpf);
			 
			 if (nacionalidade == null) {
		            stmt.setInt(3, idade);
		        } else {
		            stmt.setString(3, nacionalidade);
		            stmt.setInt(4, idade);
		        }
			 
			 stmt.execute();
	         System.out.println("Cliente inserido com sucesso!");
			 
		 }catch(SQLException | ClassNotFoundException e) {
			 e.printStackTrace();
		 }
	}
	
	public void selecionarCliente(Integer ID) {
		
		String sql;
		
		if(ID != null) {
			sql = "SELECT * FROM cliente WHERE Id_cliente = ?";
		}else {
			sql = "SELECT * FROM cliente";
		}
		
	    try (Connection conexao = ConectarBD.conectarBancoDeDados();
	         PreparedStatement stmt = conexao.prepareStatement(sql)) {

	        if (ID != null) {
	            stmt.setInt(1, ID);
	        }

	        try (ResultSet rset = stmt.executeQuery()) {

	            while (rset.next()) {
	                int id = rset.getInt("Id_cliente");
	                String nome = rset.getString("Nome_cliente");
	                String cpf = rset.getString("Cpf_cliente");
	                String nacionalidade = rset.getString("Nacionalidade");
	                int idade = rset.getInt("Idade_cliente");

	                System.out.printf(
	                	    "ID: %-5d | Nome: %-20s | CPF: %-14s | Nacionalidade: %-15s | Idade: %-3d%n",
	                	    id, nome, cpf, nacionalidade, idade
	                	);

	            }
	        }
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}

	public void atualizarCliente(int ID,String novoNome, String novoCpf, String novaNacionalidade, Integer novaIdade) {
		StringBuilder sql = new StringBuilder("UPDATE cliente SET ");
		
		if(novoNome != null) {
			sql.append("Nome_Cliente = ?,");
		}
		if(novoCpf != null) {
			sql.append(" Cpf_Cliente = ?,");
		}
		if(novaNacionalidade != null) {
			sql.append(" Nacionalidade = ?,");
		}
		if(novaIdade != null) {
			sql.append(" Idade_cliente = ?");
		}
		
		sql.append(" WHERE Id_cliente = ?");
		
		try(Connection conexao = ConectarBD.conectarBancoDeDados();
				 PreparedStatement stmt = conexao.prepareStatement(sql.toString())){
			
			int i = 1;
			if(novoNome != null) {
				stmt.setString(i, novoNome);
				i++;
			}
			if(novoCpf != null) {
				stmt.setString(i, novoCpf);
				i++;
			}
			if(novaNacionalidade != null) {
				stmt.setString(i, novaNacionalidade);
				i++;
			}
			if(novaIdade != null) {
				stmt.setInt(i, novaIdade);
				i++;
			}
			
			stmt.setInt(i, ID);
			
			stmt.execute();
			System.out.println("Cliente Atualizado com Sucesso");
			
		}catch(SQLException | ClassNotFoundException e) {
			 e.printStackTrace();
		}
	
	}

	public void deletarCliente(int ID) {
		
		String sql = "DELETE FROM cliente WHERE Id_cliente = ?";
		
		try(Connection conexao = ConectarBD.conectarBancoDeDados();
				 PreparedStatement stmt = conexao.prepareStatement(sql)){
			
			stmt.setInt(1, ID);
			
			stmt.execute();
			System.out.println("Cliente Deletado com Sucesso");
			
		}catch(SQLException | ClassNotFoundException e) {
			 e.printStackTrace();
		 }
	}
}


