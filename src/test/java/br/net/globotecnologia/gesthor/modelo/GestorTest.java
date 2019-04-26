package br.net.globotecnologia.gesthor.modelo;

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
}