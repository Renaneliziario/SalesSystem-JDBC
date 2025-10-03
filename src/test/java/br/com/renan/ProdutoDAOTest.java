/**
 * 
 */
package br.com.renan;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.renan.dao.IProdutoDAO;
import br.com.renan.dao.ProdutoDAO;
import br.com.renan.domain.Produto;
import br.com.renan.exceptions.DAOException;
import br.com.renan.exceptions.MaisDeUmRegistroException;
import br.com.renan.exceptions.TableException;
import br.com.renan.exceptions.TipoChaveNaoEncontradaException;

/**
@author renan.eliziario
 *
 */
public class ProdutoDAOTest {
	
	private IProdutoDAO produtoDao;

	public ProdutoDAOTest() {
		produtoDao = new ProdutoDAO();
	}
	
	@After
	public void end() throws DAOException {
		Collection<Produto> list = produtoDao.buscarTodos();
		list.forEach(prod -> {
			try {
				produtoDao.excluir(prod.getCodigo());
			} catch (DAOException e) {
				e.printStackTrace();
			}
		});
	}

	private Produto criarProduto(String codigo, String marca) throws TipoChaveNaoEncontradaException, DAOException {
		Produto produto = new Produto();
		produto.setCodigo(codigo);
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
		produto.setMarca(marca);
		produtoDao.cadastrar(produto);
		return produto;
	}
	
	private void excluir(String valor) throws DAOException {
		this.produtoDao.excluir(valor);
	}
	
	@Test
	public void pesquisar() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
		Produto produto = criarProduto("A1", "Apple");
		Assert.assertNotNull(produto);
		Produto produtoDB = this.produtoDao.consultar(produto.getCodigo());
		Assert.assertNotNull(produtoDB);
		Assert.assertEquals("Apple", produtoDB.getMarca());
		excluir(produtoDB.getCodigo());
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		Produto produto = criarProduto("A2", "Samsung");
		Assert.assertNotNull(produto);
		Produto produtoDB = this.produtoDao.consultar(produto.getCodigo());
		Assert.assertEquals("Samsung", produtoDB.getMarca());
		excluir(produto.getCodigo());
	}
	
	@Test
	public void excluir() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
		Produto produto = criarProduto("A3", "Sony");
		Assert.assertNotNull(produto);
		excluir(produto.getCodigo());
		Produto produtoBD = this.produtoDao.consultar(produto.getCodigo());
		assertNull(produtoBD);
	}
	
	@Test
	public void alterarProduto() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		Produto produto = criarProduto("A4", "Dell");
		produto.setNome("Rodrigo Pires");
		produto.setMarca("Lenovo");
		produtoDao.alterar(produto);
		Produto produtoBD = this.produtoDao.consultar(produto.getCodigo());
		assertNotNull(produtoBD);
		Assert.assertEquals("Rodrigo Pires", produtoBD.getNome());
		Assert.assertEquals("Lenovo", produtoBD.getMarca());
		
		excluir(produto.getCodigo());
		Produto produtoBD1 = this.produtoDao.consultar(produto.getCodigo());
		assertNull(produtoBD1);
	}
	
	@Test
	public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
		criarProduto("A5", "LG");
		criarProduto("A6", "Motorola");
		Collection<Produto> list = produtoDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);

		boolean encontrouLG = false;
		boolean encontrouMotorola = false;
		for (Produto prod : list) {
			if ("LG".equals(prod.getMarca())) encontrouLG = true;
			if ("Motorola".equals(prod.getMarca())) encontrouMotorola = true;
			excluir(prod.getCodigo());
		}
		Assert.assertTrue(encontrouLG);
		Assert.assertTrue(encontrouMotorola);
		
		list = produtoDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 0);
	}
}