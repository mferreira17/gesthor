package br.net.globotecnologia.gesthor.controlador;

public abstract class RootController {

	public String lista() {
		String nomeClass = this.getClass().getSimpleName();
		String classe[] = nomeClass.split("Controller");
		return classe[0].concat("/lista").toLowerCase();
	}
	
}
