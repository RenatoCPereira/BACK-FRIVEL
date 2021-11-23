package br.com.example.appMain.model.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReceita;

	@Column(name = "Descricao")
	@NotBlank(message = "Informe a descricao")
	private String descricao;

	@Column(name = "dtReceita")
	@NotBlank(message = "Informe a dtReceita")
	private Date dataReceita;

	@Column(name = "vlReceita")
	@NotBlank(message = "Informe o vlReceita")
	private double valorReceita;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = true)
	private Usuario usuario;

	public Receita(int idReceita, @NotBlank(message = "Informe a descricao") String descricao,
			@NotBlank(message = "Informe a dtReceita") Date dataReceita,
			@NotBlank(message = "Informe o vlReceita") double valorReceita, Usuario usuario) {
		this.idReceita = idReceita;
		this.descricao = descricao;
		this.dataReceita = dataReceita;
		this.valorReceita = valorReceita;
		this.usuario = usuario;
	}

	public Receita() {

	}

	public int getIdReceita() {
		return idReceita;
	}

	public void setIdReceita(int idReceita) {
		this.idReceita = idReceita;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataReceita() {
		return dataReceita;
	}

	public void setDataReceita(Date dataReceita) {
		this.dataReceita = dataReceita;
	}

	public double getValorReceita() {
		return valorReceita;
	}

	public void setValorReceita(double valorReceita) {
		this.valorReceita = valorReceita;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
