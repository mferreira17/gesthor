package br.net.globotecnologia.gesthor.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpresaController extends RootController{
	
	@Override
	@GetMapping("/empresas/lista")
	public String lista() {
		return super.lista();
	}

}
