package projeto_Banco_De_Dados;

public class Funcionario {
	private String cpf;
	private String nome;
	private String telefone;
	private int idade;
	
	public Funcionario(String cpf, String nome, String telefone, int idade) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}
