/**
 * 
 */
package br.com.renan.services.generic;

import java.io.Serializable;
import java.util.Collection;

import br.com.renan.dao.Persistente;
import br.com.renan.dao.generic.IGenericDAO;
import br.com.renan.exceptions.DAOException;
import br.com.renan.exceptions.MaisDeUmRegistroException;
import br.com.renan.exceptions.TableException;
import br.com.renan.exceptions.TipoChaveNaoEncontradaException;

/**
@author renan.eliziario
 *
 */
public abstract class GenericService<T extends Persistente, E extends Serializable> 
	implements IGenericService<T, E> {
	
	protected IGenericDAO<T,E> dao;
	
	public GenericService(IGenericDAO<T,E> dao) {
		this.dao = dao;
	}

	@Override
	public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		return this.dao.cadastrar(entity);
	}

	@Override
	public void excluir(E valor) throws DAOException {
		this.dao.excluir(valor);
	}

	@Override
	public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		this.dao.alterar(entity);
	}

	@Override
	public T consultar(E valor) throws DAOException {
		try {
			return this.dao.consultar(valor);
		} catch (Exception e) {
			throw new DAOException("ERRO CONSULTANDO OBJETO ", e);
		}
	}

	@Override
	public Collection<T> buscarTodos() throws DAOException {
		return this.dao.buscarTodos();
	}

}
