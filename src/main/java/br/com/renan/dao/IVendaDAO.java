/**
 * 
 */
package br.com.renan.dao;

import br.com.renan.dao.generic.IGenericDAO;
import br.com.renan.domain.Venda;
import br.com.renan.exceptions.DAOException;
import br.com.renan.exceptions.TipoChaveNaoEncontradaException;

/**
@author renan.eliziario
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
