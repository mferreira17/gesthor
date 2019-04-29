package br.net.globotecnologia.gesthor;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.net.globotecnologia.gesthor.modelo.EmpresaTest;
import br.net.globotecnologia.gesthor.modelo.GestorTest;

@RunWith(Suite.class)
@SuiteClasses({ GestorTest.class, EmpresaTest.class})
public class AllModeloTests {

}
