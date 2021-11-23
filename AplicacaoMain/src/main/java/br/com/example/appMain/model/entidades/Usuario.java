package br.com.example.appMain.model.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Nome")
	@NotBlank(message = "Informe o nome")
	private String nome;

	@Column(name = "Senha")
	@NotBlank(message = "Informe a senha")
	private String senha;

	@Column(name = "Email")
	@NotBlank(message = "Informe o email")
	private String email;

	@OneToMany(mappedBy = "usuario")
	private List<Meta> meta;

	@OneToMany(mappedBy = "usuario")
	private List<Receita> receita;

	@OneToMany(mappedBy = "usuario")
	private List<Gastos> gastos;

	public Usuario() {
	}

	public Usuario(int id, @NotBlank(message = "Informe o nome") String nome,
			@NotBlank(message = "Informe a senha") String senha, @NotBlank(message = "Informe o email") String email,
			List<Meta> meta, List<Receita> receita, List<Gastos> gastos) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.meta = meta;
		this.receita = receita;
		this.gastos = gastos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Meta> getMeta() {
		return meta;
	}

	public void setMeta(List<Meta> meta) {
		this.meta = meta;
	}

	public List<Receita> getReceita() {
		return receita;
	}

	public void setReceita(List<Receita> receita) {
		this.receita = receita;
	}

	public List<Gastos> getGastos() {
		return gastos;
	}

	public void setGastos(List<Gastos> gastos) {
		this.gastos = gastos;
	}
	

}
