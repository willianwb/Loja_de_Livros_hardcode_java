package Classes;

import java.io.Serializable;

public class Cliente implements Comparable<Cliente>,Serializable{
	private String nome;
	private String senha;
	private String email;
	
	public Cliente(String nome, String senha, String email) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(Cliente c) {
		return nome.compareToIgnoreCase(c.getNome());
	}
	
	


}
