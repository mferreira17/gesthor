package br.net.globotecnologia.gesthor.servicos;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

//import net.sf.jasperreports.engine.JRException;

@Service
public class RelatorioService {
	
	@Value("classpath:/static/relatorios/gesthorcontratos.jasper")
	private Resource resource;
	
	public void doRelatorio() throws IOException/*, JRException*/{
		
		/*JasperPrint jprint = JasperFillManager.fillReport(resource.getInputStream(), new HashMap<>());
		
		JRPdfExporter export = new JRPdfExporter();
		
		export.setExporterInput(new SimpleExporterInput(jprint));
		export.setExporterOutput(new SimpleOutputStreamExporterOutput("total_contratos.pfg"));
		export.setConfiguration(new SimplePdfExporterConfiguration());
		
		export.exportReport();*/
		
	}

}
