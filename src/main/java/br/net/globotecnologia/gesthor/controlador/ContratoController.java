package br.net.globotecnologia.gesthor.controlador;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.net.globotecnologia.gesthor.modelo.Contrato;
import br.net.globotecnologia.gesthor.modelo.Empresa;
import br.net.globotecnologia.gesthor.modelo.Gestor;
import br.net.globotecnologia.gesthor.modelo.Status;
import br.net.globotecnologia.gesthor.repositorio.ContratoRepository;
import br.net.globotecnologia.gesthor.repositorio.EmpresaRepository;
import br.net.globotecnologia.gesthor.repositorio.GestorRepository;
import br.net.globotecnologia.gesthor.servicos.relatorios.RelatorioService;

@Controller
public class ContratoController{
	
	private Integer totalContratos = 0;
	
	@Autowired
	private ContratoRepository contratoRepository;

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private GestorRepository gestorRepository;
	
	@Autowired
	private RelatorioService relService;
	
	
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
		return "redirect:/contratos/lista";
	}
	
	@ModelAttribute("empresas")
	public List<Empresa> getListaEmpresas(){
		return (List<Empresa>) empresaRepository.findAll();
	}
	
	@ModelAttribute("gestores")
	public List<Gestor> getListaGestores(){
		return (List<Gestor>) gestorRepository.findAll();
	}
	
	@ModelAttribute("contratos")
	public List<Contrato> getListaContratos(){
		List<Contrato> contratos = (List<Contrato>) contratoRepository.findAll();
		totalContratos = contratos.size();
		return contratos;
	}
	
	@ModelAttribute("totalContratos")
	public Integer getTotalContratos() {
		return totalContratos;
	}
	
	@ModelAttribute("status")
	public Status[] getListaStatus(){
		return Status.values();
	}
	
	@InitBinder
	public void bigDecimalConverter(WebDataBinder binder) {
		DecimalFormat df = new DecimalFormat();
	    DecimalFormatSymbols dfs = new DecimalFormatSymbols();
	    dfs.setGroupingSeparator('.');
	    dfs.setDecimalSeparator(',');
	    df.setDecimalFormatSymbols(dfs);
	    binder.registerCustomEditor(BigDecimal.class, new CustomNumberEditor(BigDecimal.class, df, true));
	}
	
	@GetMapping(value="/contratos/relatorio")
	public void doRelatorio(HttpServletResponse response) throws IOException{
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		response.setHeader("Content-Disposition", "inline; filename=total_contratos.pdf");
		relService.doRelatorio(response.getOutputStream());
	}

}
