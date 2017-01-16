package br.com.estudos.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.estudos.dao.AbstractDao;
import br.com.estudos.dao.interfaces.IPessoa;
import br.com.estudos.model.Pessoa;


/**
 * Essa é uma classe DAO do tipo PESSOA, ela extende uma classe abstrada que possui um contrutor
 * que obriga passar uma conexão para quem o estanciar, dar new.
 * Ela implementa uma interface de Pessoa.
 * @author jefferson
 */
public class PessoaDao extends AbstractDao implements IPessoa{

	public PessoaDao(Connection connection) {
		super(connection);
	}

	public void insert(Pessoa pessoa) throws Exception {
		
		String SQL = "INSERT INTO PESSOA "
				+ "(NOME,SOBRENOME,ESTADOCIVIL,CPF,RG,DATA) "
				+ "VALUES (?,?,?,?,?,SYSDATE())";
		
		PreparedStatement ps = this.connection.prepareStatement(SQL);
		ps.setString(1, pessoa.getNome());
		ps.setString(2, pessoa.getSobrenome());
		ps.setString(3, pessoa.getEstadocivil());
		ps.setString(4, pessoa.getCpf());
		ps.setString(5, pessoa.getRg());
		ps.execute();
		ps.close();
		this.connection.close();		
	}

	public void update(Pessoa pessoa) throws Exception {
		
		String SQL = "UPDATE PESSOA SET NOME=?, SOBRENOME=?, ESTADOCIVIL=?, CPF=?, RG=?, DATA=SYSDATE()"
				+ "WHERE ID=?";
		PreparedStatement ps = this.connection.prepareStatement(SQL);
		ps.setString(1, pessoa.getNome());
		ps.setString(2, pessoa.getSobrenome());
		ps.setString(3, pessoa.getEstadocivil());
		ps.setString(4, pessoa.getCpf());
		ps.setString(5, pessoa.getRg());
		ps.setLong(6, pessoa.getId());
		ps.execute();
		ps.close();
		this.connection.close();
	}

	public void delete(Integer id) throws Exception {
		
		String SQL = "DELETE FROM PESSOA WHERE ID=?";
		
		PreparedStatement ps = this.connection.prepareStatement(SQL);
		ps.setLong(1, id);
		ps.execute();
		ps.close();
		this.connection.close();	
	}

	public List<Pessoa> listAll() throws Exception {
	
		String SQL = "SELECT * FROM PESSOA";
		
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		PreparedStatement ps = this.connection.prepareStatement(SQL);
		ResultSet rs = (ResultSet) ps.executeQuery();
		
		while(rs.next()) {
			
			Pessoa pessoa = new Pessoa();
		
			pessoa.setCpf(rs.getString("CPF"));
			pessoa.setData(rs.getDate("DATA"));
			pessoa.setEstadocivil(rs.getString("ESTADOCIVIL"));
			pessoa.setId(rs.getInt("ID"));
			pessoa.setNome(rs.getString("NOME"));
			pessoa.setRg(rs.getString("RG"));
			pessoa.setSobrenome(rs.getString("SOBRENOME"));
			
			pessoas.add(pessoa);
		}
		
		
		return null;
	}

	
}
