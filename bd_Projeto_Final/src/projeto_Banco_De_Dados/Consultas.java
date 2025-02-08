package projeto_Banco_De_Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultas {
	
	public void consultaComInnerJoin() {
		
		String sql = "SELECT Id_compra,Nome_prod,Valor_prod,Quant_prod,Valor_total,forma_pagam " +
		"FROM compra INNER JOIN produto ON Comp_prod = Id_prod";
		
		try (Connection conexao = ConectarBD.conectarBancoDeDados();
		         PreparedStatement stmt = conexao.prepareStatement(sql);
		        		 ResultSet rset = stmt.executeQuery()){
			
			while(rset.next()) {
				
				 int id = rset.getInt("Id_compra");
				 String nome = rset.getString("Nome_prod");
	             double valor = rset.getDouble("Valor_prod");
	             int quantidade = rset.getInt("Quant_prod");
	             double valorTotal = rset.getDouble("Valor_total");
	             String forma = rset.getString("forma_pagam");

	             System.out.printf(
	            		    "Id_prod: %-5d | Nome_prod: %-15s | Valor_prod: R$%-8.2f | Quant_prod: %-3d | Valor_total: R$%-8.2f | Forma_pagamento: %s%n",
	            		    id, nome, valor, quantidade, valorTotal, forma
	            		);
			}
			
		} catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	public void consultaComRightJoin() {
		
		String sql = "SELECT Id_compra,Nome_prod,Valor_prod,Quant_prod,Valor_total,forma_pagam " +
				"FROM compra RIGHT JOIN produto ON Comp_prod = Id_prod";
		
		try (Connection conexao = ConectarBD.conectarBancoDeDados();
		         PreparedStatement stmt = conexao.prepareStatement(sql);
		        		 ResultSet rset = stmt.executeQuery()){
			
			while(rset.next()) {
				
				 int id = rset.getInt("Id_compra");
				 String nome = rset.getString("Nome_prod");
	             double valor = rset.getDouble("Valor_prod");
	             int quantidade = rset.getInt("Quant_prod");
	             double valorTotal = rset.getDouble("Valor_total");
	             String forma = rset.getString("forma_pagam");

	             System.out.printf(
	            		    "Id_prod: %-5d | Nome_prod: %-15s | Valor_prod: R$%-8.2f | Quant_prod: %-3d | Valor_total: R$%-8.2f | Forma_pagamento: %s%n",
	            		    id, nome, valor, quantidade, valorTotal, forma
	            		);

			}
			
		} catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}

	public void consultaQuantificador() {
		
		String sql = "SELECT Id_compra, Comp_prod, Valor_total, Quant_prod " +
		"FROM compra WHERE Valor_total > ANY (SELECT Valor_prod FROM produto)";
		
		try (Connection conexao = ConectarBD.conectarBancoDeDados();
		         PreparedStatement stmt = conexao.prepareStatement(sql);
		        		 ResultSet rset = stmt.executeQuery()){
			
			while(rset.next()) {
				
				 int id = rset.getInt("Id_compra");
				 int idP = rset.getInt("Comp_prod");
				 double valorTotal = rset.getDouble("Valor_total");
	             int quantidade = rset.getInt("Quant_prod");

	             System.out.printf(
	            		    "Id_compra: %-5d | Comp_prod: %-5d | Valor_total: R$%-8.2f | Quant_prod: %-3d%n",
	            		    id, idP, valorTotal, quantidade
	            		);
			}
			
		} catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	
}
