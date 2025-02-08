package projeto_Banco_De_Dados;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		ClienteDAO cliente = new ClienteDAO();
		FuncionarioDAO funcionario = new FuncionarioDAO();
		Consultas consulta = new Consultas();
		
		//cliente.inserirCliente("Gerdal", "82476654984",null, 42);
		
		cliente.selecionarCliente(null);
		
		//cliente.stualizarCliente(2, "Maria Janaina", null, "brasileira", 40);
		
		//cliente.deletarCliente(2);
		
		//List<Funcionario> funcAtributos = new ArrayList<>();
		//funcAtributos.add(new Funcionario("44433322211", "João", "929292333", 81));
		//funcAtributos.add(new Funcionario("44411144455", "Zinho", "99395999", 91));
		//funcAtributos.add(new Funcionario("12132343456", "João", null, 0));
		//funcionario.inserirFuncionario(funcAtributos);
		
		//funcionario.selecionaPorSubString("João");
		
		//consulta.consultaComInnerJoin();
		//consulta.consultaComRightJoin();
		//consulta.consultaQuantificador();
	}

}
