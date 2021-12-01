package br.com.example.appMain.model.entidades;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Meta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMeta;

	@Column(name = "dtMeta")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dtMeta;

	@Column(name = "Descricao")
	@NotBlank(message = "Informe a descricao")
	private String descricao;

	@Column(name = "Name")
	@NotBlank(message = "Informe o nome")
	private String nome;

	@Column(name = "vlMeta")
	private double vlMeta;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = true)
	private Usuario usuario;

	public Meta(int idMeta, LocalDate dtMeta, @NotBlank(message = "Informe a descricao") String descricao,
			@NotBlank(message = "Informe o nome") String nome, double vlMeta, Usuario usuario) {
		this.idMeta = idMeta;
		this.dtMeta = dtMeta;
		this.descricao = descricao;
		this.nome = nome;
		this.vlMeta = vlMeta;
		this.usuario = usuario;
	}

	public Meta() {

	}

	public int getIdMeta() {
		return idMeta;
	}

	public void setIdMeta(int idMeta) {
		this.idMeta = idMeta;
	}

	public LocalDate getDtMeta() {
		return dtMeta;
	}

	public void setDtMeta(LocalDate dtMeta) {
		this.dtMeta = dtMeta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getVlMeta() {
		return vlMeta;
	}

	public void setVlMeta(double vlMeta) {
		this.vlMeta = vlMeta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
