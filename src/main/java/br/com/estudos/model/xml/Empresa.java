package br.com.estudos.model.xml;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="empresa")
@XmlAccessorType(XmlAccessType.FIELD)
public class Empresa {

	@XmlElement(name="nomeFantasia")
	private String nomeFantasia;
	
	@XmlElement(name="cnpj")
	private String cnpj;
	
	@XmlElementWrapper(name="telefones")
	@XmlElement(name="telefone")
	private ArrayList<Telefone> telefones;
	
	@XmlElement(name="endereco")
	private String endereco;

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public ArrayList<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(ArrayList<Telefone> telefones) {
		this.telefones = telefones;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Empresa [nomeFantasia=" + nomeFantasia + ", cnpj=" + cnpj + ", telefones=" + telefones + ", endereco="
				+ endereco + "]";
	}
	
	
	
}
