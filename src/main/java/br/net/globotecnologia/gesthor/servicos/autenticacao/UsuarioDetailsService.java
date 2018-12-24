package br.net.globotecnologia.gesthor.servicos.autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.net.globotecnologia.gesthor.modelo.autenticacao.Usuario;
import br.net.globotecnologia.gesthor.modelo.autenticacao.UsuarioCustomDetail;
import br.net.globotecnologia.gesthor.repositorio.autenticacao.PermissaoRepository;
import br.net.globotecnologia.gesthor.repositorio.autenticacao.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository urepository;
	
	@Autowired
	private PermissaoRepository prepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = urepository.findByLogin(username);
		
		if(usuario != null){
			return new UsuarioCustomDetail(usuario, prepository.findByUsuario(usuario));
		}else{
			throw new UsernameNotFoundException("Usuario nao encontrado");
		}
		
	}

}
