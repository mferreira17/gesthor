package br.net.globotecnologia.gesthor.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GestorController {
	
	@GetMapping("/contratos/lista")
	public String lista() {
		return "contrato/lista";
	}

}
