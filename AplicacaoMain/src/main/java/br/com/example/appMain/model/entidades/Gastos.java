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
public class Gastos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGasto;

	@Column(name = "Descricao")
	@NotBlank(message = "Informe o descricao")
	private String descricao;

	@Column(name = "Categoria")
	@NotBlank(message = "Informe a recorrencia")
	private String categoria;

	@Column(name = "TipoDoGasto")
	@NotBlank(message = "Informe a recorrencia")
	private String tipoDoGasto;

	@Column(name = "vlGasto")
	private double valor;

	@Column(name = "dtGasto")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dtGastos;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = true)
	private Usuario usuario;

	public Gastos(int idGasto, @NotBlank(message = "Informe o descricao") String descricao,
			@NotBlank(message = "Informe a recorrencia") String categoria,
			@NotBlank(message = "Informe a recorrencia") String tipoDoGasto, double valor, LocalDate dtGastos,
			Usuario usuario) {
		this.idGasto = idGasto;
		this.descricao = descricao;
		this.categoria = categoria;
		this.tipoDoGasto = tipoDoGasto;
		this.valor = valor;
		this.dtGastos = dtGastos;
		this.usuario = usuario;
	}

	public Gastos() {

	}

	public int getIdGasto() {
		return idGasto;
	}

	public void setIdGasto(int idGasto) {
		this.idGasto = idGasto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTipoDoGasto() {
		return tipoDoGasto;
	}

	public void setTipoDoGasto(String tipoDoGasto) {
		this.tipoDoGasto = tipoDoGasto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getDtGastos() {
		return dtGastos;
	}

	public void setDtGastos(LocalDate dtGastos) {
		this.dtGastos = dtGastos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
