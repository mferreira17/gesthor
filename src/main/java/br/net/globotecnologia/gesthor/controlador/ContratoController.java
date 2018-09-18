package br.net.globotecnologia.gesthor.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.net.globotecnologia.gesthor.modelo.Contrato;

@Controller
public class ContratoController {
	
	@GetMapping("/contratos/lista")
	public String lista(){
		return "contrato/lista";
	}
	
	@GetMapping("/contratos/novo")
	public String novo(Contrato contrato){
		return "contrato/novo";
	}

}
