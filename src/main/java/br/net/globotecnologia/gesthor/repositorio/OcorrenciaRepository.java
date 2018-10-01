package br.net.globotecnologia.gesthor.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.net.globotecnologia.gesthor.modelo.Ocorrencia;

public interface OcorrenciaRepository extends CrudRepository<Ocorrencia, Long> {

	@Query("select o From Ocorrencia o join Contrato c On o.contrato = c and c.id =:idContrato")
	List<Ocorrencia> findAllByContratoId(@Param("idContrato") Long idContrato);

}
