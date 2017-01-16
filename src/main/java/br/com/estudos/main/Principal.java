package br.com.estudos.main;

import br.com.estudos.business.PessoaBusiness;

public class Principal {

	public static void main(String[] args) throws Exception {

		int length = args.length;
		
		if(length > 1) {
			
			if(length >= 2) {
				if(args[0].toLowerCase().equals("pessoa")){
					
					PessoaBusiness business = new PessoaBusiness();
					business.begin(args);
				}
			}
			
		else {
			throw new Exception("Falta parametros");
		}
		}
	}
}
