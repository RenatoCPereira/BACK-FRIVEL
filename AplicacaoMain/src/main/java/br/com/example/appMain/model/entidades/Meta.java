package br.com.example.appMain.model.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Meta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMeta;

	@Column(name="dlMeta")
	private Date dtMeta;

	@Column(name="Descricao")
	private String descricao;

	@Column(name="Name")
	private String nome;
	
	@Column(name="vlMeta")
	private double vlMeta;

	public Meta(int idMeta, Date dtMeta, String descricao, String nome, double vlMeta) {
		this.idMeta = idMeta;
		this.dtMeta = dtMeta;
		this.descricao = descricao;
		this.nome = nome;
		this.vlMeta = vlMeta;
	}

	public Meta() {

	}

	public int getIdMate() {
		return idMeta;
	}

	public void setIdMate(int idMate) {
		this.idMeta = idMate;
	}

	public Date getDtMeta() {
		return dtMeta;
	}

	public void setDtMeta(Date dtMeta) {
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
	
	

}
