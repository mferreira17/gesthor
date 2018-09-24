package br.net.globotecnologia.gesthor.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.net.globotecnologia.gesthor.modelo.Contrato;
import br.net.globotecnologia.gesthor.modelo.Empresa;
import br.net.globotecnologia.gesthor.modelo.Gestor;
import br.net.globotecnologia.gesthor.modelo.Status;
import br.net.globotecnologia.gesthor.repositorio.ContratoRepository;
import br.net.globotecnologia.gesthor.repositorio.EmpresaRepository;
import br.net.globotecnologia.gesthor.repositorio.GestorRepository;

@Controller
public class ContratoController{
	
	@Autowired
	private ContratoRepository contratoRepository;

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private GestorRepository gestorRepository;
	
	@GetMapping("/contratos/lista")
	public String lista(){
		return "contrato/lista";
	}
	
	@GetMapping("/contratos/novo")
	public String novo(Contrato contrato){
		return "contrato/novo";
	}
	
	@PostMapping("/contratos/salvar")
	public String salvar(Contrato contrato) {
		contratoRepository.save(contrato);
		return lista();
	}
	
	@ModelAttribute("empresas")
	public List<Empresa> getListaEmpresas(){
		return (List<Empresa>) empresaRepository.findAll();
	}
	
	@ModelAttribute("gestores")
	public List<Gestor> getListaGestores(){
		return (List<Gestor>) gestorRepository.findAll();
	}
	
	@ModelAttribute("status")
	public Status[] getListaStatus(){
		return Status.values();
	}
	
	

}
