package br.net.globotecnologia.gesthor.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.net.globotecnologia.gesthor.modelo.Empresa;
import br.net.globotecnologia.gesthor.repositorio.EmpresaRepository;

@Controller
public class EmpresaController{
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@GetMapping("/empresas/lista")
	public String lista() {
		return "empresa/lista";
	}

	@GetMapping("/empresas/novo")
	public String novo(Empresa empresa){
		return "empresa/novo";
	}
	
	@PostMapping("/empresas/salvar")
	public String salvar(Empresa empresa) {
		empresaRepository.save(empresa);
		return "redirect:/empresas/lista";
	}
	
	@ModelAttribute("empresas")
	public List<Empresa> getListaEmpresas(){
		return (List<Empresa>) empresaRepository.findAll();
	}
}
