package br.net.globotecnologia.gesthor.modelo;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.net.globotecnologia.gesthor.mock.GestorRepositoryMock;

@RunWith(MockitoJUnitRunner.class)
public class GestorTest {

	@Mock
	GestorRepositoryMock repositorio;
	private Gestor gestor;

	@Test(expected = NullPointerException.class)
	public void testSalvarNulo() {
		gestor = null;
		if (gestor.equals(null))
			throw new NullPointerException("Gestor nulo.");
		repositorio.save(gestor);
	}

	@Test
		public void testSalvar() {
			gestor = new Gestor("Ernani", "Informática", "4002 8922");
			repositorio.save(gestor);
		}
	
	@Test
	public void testCadastroGestor() {

		Gestor gestor = new Gestor();
		gestor.setNome("ANDERSON BRAGA");
		gestor.setSetor("RH");
		gestor.setTelefone("32631227");

		repositorio.save(gestor);

		List<Gestor> gestores = (List<Gestor>) repositorio.findAll();

		Optional<Gestor> optional = gestores.stream().filter(ges -> ges.getNome().equals("ANDERSON BRAGA")).findFirst();

		assertNotNull(optional);

	}
}