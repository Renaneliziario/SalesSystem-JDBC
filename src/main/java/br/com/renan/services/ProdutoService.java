package br.com.renan.services;

import br.com.renan.dao.IProdutoDAO;
import br.com.renan.domain.Produto;
import br.com.renan.exceptions.DAOException;
import br.com.renan.exceptions.TipoChaveNaoEncontradaException;
import br.com.renan.services.generic.GenericService;

/**
@author renan.eliziario
 *
 */

 public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

	@Override
	public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException, DAOException {
		boolean cadastrado = super.cadastrar(entity);		
		return cadastrado;
	}

}



