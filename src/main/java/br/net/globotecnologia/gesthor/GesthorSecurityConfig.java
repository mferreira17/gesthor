package br.net.globotecnologia.gesthor;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity(debug = false)
public class GesthorSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/*
		 * Clausula permitindo que qualquer usuário atinga a raiz da aplicação (/),
		 * porém apenas usuarios autenticados(logados) e com a ROLE GESTOR possam
		 * acessar o que estiver abaixo de /contratos, /empresas e /gestores. Ao final
		 * pede para adicionar o formulario de login
		 */
		http.authorizeRequests().antMatchers("/").permitAll()
				.antMatchers("/contratos/**", "/empresas/**", "/gestores/**", "/ocorrencias/**").hasRole("GESTOR")
				.anyRequest().authenticated().and().formLogin().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * Definido o encoder de senha, estou definindo um usuario gestor , com senha
		 * gestor e role GESTOR
		 */

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		auth.inMemoryAuthentication().passwordEncoder(encoder).withUser("gestor").password(encoder.encode("gestor"))
				.roles("GESTOR");
	}

}
