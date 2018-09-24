package br.net.globotecnologia.gesthor.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.net.globotecnologia.gesthor.modelo.Contrato;
import br.net.globotecnologia.gesthor.modelo.Gestor;

@Controller
public class GestorController {
	
	@GetMapping("/gestores/lista")
	public String lista() {
		return "gestor/lista";
	}
	
	@GetMapping("/gestores/novo")
	public String novo(Gestor gestor){
		return "gestor/novo";
	}

}
