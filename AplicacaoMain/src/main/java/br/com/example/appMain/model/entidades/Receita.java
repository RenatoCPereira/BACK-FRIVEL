package br.com.example.appMain.model.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Receita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReceita;
	
	@Column(name="idUsur")
	private int idUsuario;
	
	private String descricao;
	
	@Column(name="dtReceita")
	private Date dataReceita;
	
	@Column(name="vlReceita")
	private double valorReceita;

	public Receita(int idReceita, int idUsuario, String descricao, Date dataReceita, double valorReceita) {
		this.idReceita = idReceita;
		this.idUsuario = idUsuario;
		this.descricao = descricao;
		this.dataReceita = dataReceita;
		this.valorReceita = valorReceita;
	}
	
	public Receita() {
	
	}

	public int getIdReceita() {
		return idReceita;
	}

	public void setIdReceita(int idReceita) {
		this.idReceita = idReceita;
	}

	public int getIdUusario() {
		return idUsuario;
	}

	public void setIdUusario(int idUusario) {
		this.idUsuario = idUusario;
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
	
	

}
