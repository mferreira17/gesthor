package br.net.globotecnologia.gesthor.repositorio.autenticacao;

import org.springframework.data.repository.CrudRepository;

import br.net.globotecnologia.gesthor.modelo.autenticacao.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	public Usuario findByLogin(String login);
	

}
