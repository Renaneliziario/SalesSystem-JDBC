/**
 * 
 */
package br.com.renan.services;

import br.com.renan.dao.IClienteDAO;
import br.com.renan.domain.Cliente;
import br.com.renan.exceptions.DAOException;
import br.com.renan.exceptions.MaisDeUmRegistroException;
import br.com.renan.exceptions.TableException;
import br.com.renan.services.generic.GenericService;

/**
@author renan.eliziario
 *
 */
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
	}


	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		return super.consultar(cpf);
	}

}
