package br.com.estudos.business;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import br.com.estudos.dao.ConnectionFactory;
import br.com.estudos.dao.jdbc.PessoaDao;
import br.com.estudos.model.Pessoa;
import br.com.estudos.utils.Propriedades;

/**
 * Essa é uma classe que é chamada pela MAIN se o primeiro paramentro for 'pessoa'
 * ela le um arquivo em um diretorio ja mapeado pelo sistema, porem o nome do arquivo é passado
 * como segundo paramentro. Ele le esse arquivo e persiste no banco. 
 * @author jefferson
 */
public class PessoaJDBC {
	
	protected Connection conn = null;
	protected Properties prop = null;
	protected String pathDiretori = null;
	protected String file = null;
	protected Pessoa pessoa = null;
	protected List<Pessoa> pessoas= null;
	protected PessoaDao dao = null;
	
	public void begin(String args[]) throws Exception{
		
		start();
		
		this.file = pathDiretori.concat(args[1]);
		
		lerArquivoDevolvePessoa();
		
		for (Pessoa pessoa : this.pessoas) {
			
			this.dao.insert(pessoa);
		}
		
		end();
		
	}
	
	private void lerArquivoDevolvePessoa() {
		
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		String linha = null;
		String[] conteudoArquilo = null;
		try {
			inputStream = new FileInputStream(this.file);
			inputStreamReader = new InputStreamReader(inputStream);
			bufferedReader = new BufferedReader(inputStreamReader);
			linha = bufferedReader.readLine();
			this.pessoas = new ArrayList<Pessoa>();
			
			while(linha != null) {
				conteudoArquilo = linha.split(";");
				this.pessoa = new Pessoa();
				
				this.pessoa.setNome(conteudoArquilo[0]);
				this.pessoa.setSobrenome(conteudoArquilo[1]);
				this.pessoa.setEstadocivil(conteudoArquilo[2]);
				this.pessoa.setCpf(conteudoArquilo[3]);
				this.pessoa.setRg(conteudoArquilo[4]);
				
				this.pessoas.add(this.pessoa);
				
				linha = bufferedReader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void start() throws Exception {
		this.conn = ConnectionFactory.getConnection();
		this.prop = Propriedades.getProp();
		this.pessoa = new Pessoa();
		this.dao = new PessoaDao(this.conn);
		this.pathDiretori = this.prop.getProperty("path.file");
	}
	
	private void end() throws Exception {
		this.conn.close();
		this.prop.clone();
	}


	
	
}
