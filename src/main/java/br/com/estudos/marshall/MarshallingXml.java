package br.com.estudos.marshall;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;

import br.com.estudos.model.xml.Empresa;
import br.com.estudos.model.xml.Telefone;

public class MarshallingXml {

	protected StringWriter sw = null;
	protected Empresa empresa = null;
	
	public void JaxbMarshall() throws JAXBException, IOException {
		empresa = criaObjeto();
		sw = new StringWriter();
		
		JAXBContext context = JAXBContext.newInstance(Empresa.class);
		
		Marshaller marshaller = context.createMarshaller();
		
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		marshaller.marshal(empresa, new StreamResult(sw));
		
		Writer writer = new FileWriter("c:/dev/resultadoJeff.xml");
		
		marshaller.marshal(empresa, writer);
		
		
	}
	
	private Empresa criaObjeto() {
		Empresa empresa1 = new Empresa();
		empresa1.setNomeFantasia("Triystems");
		empresa1.setCnpj("121.541.0001/54");
		empresa1.setEndereco("Rua Genghis");
		Telefone telefone = new Telefone();
		telefone.setId(1);
		telefone.setDdd(11);
		telefone.setNumero(21325252);
		telefone.setAtivo(true);
		
		Telefone telefone2 = new Telefone();
		telefone2.setId(2);
		telefone2.setDdd(11);
		telefone2.setNumero(54545454);
		telefone2.setAtivo(false);
		
		ArrayList<Telefone> telefones = new ArrayList<Telefone>();
		telefones.add(telefone);
		telefones.add(telefone2);
		empresa1.setTelefones(telefones);
		
		return empresa1;
	}


	
}
