package br.com.estudos.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//create table pessoa(
//id INT NOT NULL AUTO_INCREMENT, 
//nome VARCHAR(255) NOT NULL,
//sobrenome VARCHAR(255) NOT NULL,
//estadocivil VARCHAR(255) NOT NULL,
//cpf VARCHAR(255) NOT NULL, 
//rg VARCHAR(255) NOT NULL,
//dataNascimento DATE NOT NULL, 
//PRIMARY KEY ( id ));

public class Pessoa {

	private Integer id;
	private String nome;
	private String sobrenome;
	private String estadocivil;
	private String cpf;
	private String rg;
	private Date data;
	
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEstadocivil() {
		return estadocivil;
	}
	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Pessoa [id=" + getId() + ", nome=" + nome + ", sobrenome=" + sobrenome + ", estadocivil=" + estadocivil
				+ ", cpf=" + cpf + ", rg=" + rg + ", data=" + data + "]";
	}
	public void setId(Integer id) {
		this.id = id;
	}
		


}
