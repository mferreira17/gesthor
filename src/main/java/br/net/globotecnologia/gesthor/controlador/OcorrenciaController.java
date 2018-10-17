package br.net.globotecnologia.gesthor.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.net.globotecnologia.gesthor.modelo.Contrato;
import br.net.globotecnologia.gesthor.modelo.Ocorrencia;
import br.net.globotecnologia.gesthor.repositorio.ContratoRepository;
import br.net.globotecnologia.gesthor.repositorio.OcorrenciaRepository;

@Controller
@RequestMapping("/ocorrencias")
public class OcorrenciaController{
	
	@Autowired
	private OcorrenciaRepository repository;
	
	@Autowired
	private ContratoRepository contratoRepository;
	
	private Contrato contrato;

	@GetMapping("/lista/{id}")
	public String lista(ModelMap model, @PathVariable("id") Long id){
		
		List<Ocorrencia> ocorrencias = repository.findAllByContratoId(id);
		
		contrato = (ocorrencias.isEmpty()) ? contratoRepository.findById(id).get() : ocorrencias.get(0).getContrato();
		
		model.addAttribute("ocorrencias", ocorrencias);
		
		return "ocorrencia/lista";
	}
	
	@GetMapping("/novo")
	public String novo(Ocorrencia ocorrencia) {
		return "ocorrencia/novo";
	}
	
	@PostMapping("/salvar")
	public String salvar(Ocorrencia ocorrencia) {
		ocorrencia.setContrato(contrato);
		repository.save(ocorrencia);
		return "redirect:/contratos/lista";
	}
	
}
