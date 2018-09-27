package br.net.globotecnologia.gesthor.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.net.globotecnologia.gesthor.modelo.Gestor;
import br.net.globotecnologia.gesthor.repositorio.GestorRepository;

@Controller
public class GestorController {
	
	@Autowired
	private GestorRepository gestorRepository;
	
	@GetMapping("/gestores/lista")
	public String lista() {
		return "gestor/lista";
	}
	
	@GetMapping("/gestores/novo")
	public String novo(Gestor gestor){
		return "gestor/novo";
	}
	
	@PostMapping("/gestores/salvar")
	public String salvar(Gestor gestor) {
		gestorRepository.save(gestor);
		return "redirect:/gestores/lista";
	}
	
	@ModelAttribute("gestores")
	public List<Gestor> getListaGestores(){
		return (List<Gestor>) gestorRepository.findAll();
	}

}
