package br.com.example.appMain.model.entidades;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// endereco

	@Column(name = "Nome")
	@NotBlank(message = "Informe o nome")
	private String nome;

	@Column(name = "Senha")
	@NotBlank(message = "Informe a senha")
	private String senha;

	@Column(name = "Email")
	@NotBlank(message = "Informe o email")
	@Email
	private String email;

	@Column(name = "DataNascimento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;

	@OneToMany(mappedBy = "usuario")
	private List<Meta> meta;

	@OneToMany(mappedBy = "usuario")
	private List<Receita> receita;

	@OneToMany(mappedBy = "usuario")
	private List<Gastos> gastos;

	public Usuario() {
	}

	public Usuario(int id, @NotBlank(message = "Informe o nome") String nome,
			@NotBlank(message = "Informe a senha") String senha,
			@NotBlank(message = "Informe o email") @Email String email, LocalDate dataNascimento, List<Meta> meta,
			List<Receita> receita, List<Gastos> gastos) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.dataNascimento = dataNascimento;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	@Override
	public int hashCode() {
		return Objects.hash(dataNascimento, email, gastos, id, meta, nome, receita, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(email, other.email)
				&& Objects.equals(gastos, other.gastos) && id == other.id && Objects.equals(meta, other.meta)
				&& Objects.equals(nome, other.nome) && Objects.equals(receita, other.receita)
				&& Objects.equals(senha, other.senha);
	}
	
	

}
