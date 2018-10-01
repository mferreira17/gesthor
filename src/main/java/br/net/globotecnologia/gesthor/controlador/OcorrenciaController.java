package br.net.globotecnologia.gesthor.controlador;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.net.globotecnologia.gesthor.modelo.Ocorrencia;
import br.net.globotecnologia.gesthor.repositorio.OcorrenciaRepository;

@Controller
@RequestMapping("/ocorrencias")
public class OcorrenciaController{
	
	@Autowired
	private OcorrenciaRepository repository;

	@GetMapping("/lista/{id}")
	public String lista(ModelMap model, @PathParam("id") Long idContrato){
		model.addAttribute("ocorrencias", repository.findAllByContratoId(idContrato));
		return "ocorrencia/lista";
	}
	
	@GetMapping("/novo")
	public String novo(Ocorrencia ocorrencia) {
		return "ocorrencia/novo";
	}
	
	/*@ModelAttribute("ocorrencias")
	public List<Ocorrencia> getOcorrencias(Long idContrato){
		return (List<Ocorrencia>) repository.findAllByContrato(idContrato);
	}*/
}
