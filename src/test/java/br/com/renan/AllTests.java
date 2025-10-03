/**
 * 
 */
package br.com.renan;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
@author renan.eliziario
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ ClienteServiceTest.class, ClienteDAOTest.class,
	ProdutoServiceTest.class, ProdutoDAOTest.class,
	VendaDAOTest.class})
public class AllTests {

}
