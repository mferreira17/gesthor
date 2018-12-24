package br.net.globotecnologia.gesthor.repositorio.autenticacao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.net.globotecnologia.gesthor.modelo.autenticacao.Permissao;
import br.net.globotecnologia.gesthor.modelo.autenticacao.Usuario;

public interface PermissaoRepository extends CrudRepository<Permissao, Long>{
	
	public List<Permissao> findByUsuario(Usuario usuario);

}
