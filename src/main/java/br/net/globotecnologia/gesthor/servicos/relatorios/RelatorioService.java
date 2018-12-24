package br.net.globotecnologia.gesthor.servicos.relatorios;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class RelatorioService {

	@Value("classpath:/templates/relatorios/gesthorcontratos.jasper")
	private Resource resource;

	@Autowired
	private DataSource dataSource;

	public void doRelatorio(OutputStream stream) {

		JasperPrint jprint = null;
		try {
			jprint = JasperFillManager.fillReport(resource.getInputStream(), new HashMap<>(),
					dataSource.getConnection());
			JasperExportManager.exportReportToPdfStream(jprint, stream);
		} catch (JRException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
