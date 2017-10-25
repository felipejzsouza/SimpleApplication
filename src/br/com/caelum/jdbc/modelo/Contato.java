package br.com.caelum.jdbc.modelo;

import java.util.Calendar;

public class Contato {
	
	private long id;
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;
	
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return this.endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Calendar getDataNascimento() {
		return this.dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
