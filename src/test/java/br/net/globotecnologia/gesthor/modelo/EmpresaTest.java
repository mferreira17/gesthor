package br.net.globotecnologia.gesthor.modelo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.net.globotecnologia.gesthor.mock.EmpresaRepositoryMock;

@RunWith(MockitoJUnitRunner.class)
public class EmpresaTest {

	@Mock
	EmpresaRepositoryMock repositorio;
	private Empresa empresa;

	@Test(expected = NullPointerException.class)
	public void testSalvarNulo() {
		empresa = null;
		if (empresa.equals(null))
			throw new NullPointerException("Empresa nula.");
		repositorio.save(empresa);
	}

	@Test
	public void testSalvar() {
		empresa = new Empresa("MS Informática", "Informática", "4002 8922");
		repositorio.save(empresa);
	}
}