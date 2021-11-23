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
public class Gastos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGastos;

	@Column(name = "vlGastos")
	@NotBlank(message = "Informe o vlGastos")
	private double vlGastos;

	@Column(name = "Descricao")
	@NotBlank(message = "Informe o descricao")
	private String descricao;

	@Column(name = "Recorrencia")
	@NotBlank(message = "Informe a recorrencia")
	private String recorrencia;

	@Column(name = "dtGastos")
	@NotBlank(message = "Informe o dtGastos")
	private Date dtGastos;

	@Column(name = "Juros")
	@NotBlank(message = "Informe o juros")
	private double juros;

	@Column(name = "dtVencimento")
	@NotBlank(message = "Informe a dtVencimento")
	private Date dtVencimento;

	@Column(name = "Parcelas")
	@NotBlank(message = "Informe as parcelas")
	private int parcelas;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = true)
	private Usuario usuario;

	public Gastos(int idGastos, @NotBlank(message = "Informe o vlGastos") double vlGastos,
			@NotBlank(message = "Informe o descricao") String descricao,
			@NotBlank(message = "Informe a recorrencia") String recorrencia,
			@NotBlank(message = "Informe o dtGastos") Date dtGastos,
			@NotBlank(message = "Informe o juros") double juros,
			@NotBlank(message = "Informe a dtVencimento") Date dtVencimento,
			@NotBlank(message = "Informe as parcelas") int parcelas, Usuario usuario) {
		this.idGastos = idGastos;
		this.vlGastos = vlGastos;
		this.descricao = descricao;
		this.recorrencia = recorrencia;
		this.dtGastos = dtGastos;
		this.juros = juros;
		this.dtVencimento = dtVencimento;
		this.parcelas = parcelas;
		this.usuario = usuario;
	}

	public Gastos() {
		
	}

	public int getIdGastos() {
		return idGastos;
	}

	public void setIdGastos(int idGastos) {
		this.idGastos = idGastos;
	}

	public double getVlGastos() {
		return vlGastos;
	}

	public void setVlGastos(double vlGastos) {
		this.vlGastos = vlGastos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getRecorrencia() {
		return recorrencia;
	}

	public void setRecorrencia(String recorrencia) {
		this.recorrencia = recorrencia;
	}

	public Date getDtGastos() {
		return dtGastos;
	}

	public void setDtGastos(Date dtGastos) {
		this.dtGastos = dtGastos;
	}

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}

	public Date getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
