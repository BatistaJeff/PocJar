package br.com.estudos.unmarshall;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.com.estudos.model.xml.Empresa;

public class UnmarshallingXml {

	protected Empresa empresa = null;
	
	public void JaxbUnmarshall(String archive) throws JAXBException, FileNotFoundException {
		
		JAXBContext context = JAXBContext.newInstance(Empresa.class);
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		Object object = unmarshaller.unmarshal(new FileInputStream(archive));
		
		empresa = ((Empresa) object);
		
		if(empresa.getNomeFantasia() != null) {
			System.out.println(empresa.toString());
		}
	}

	
	
	
	
}
