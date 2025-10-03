/**
 * 
 */
package br.com.renan.services;

import br.com.renan.domain.Cliente;
import br.com.renan.exceptions.DAOException;
import br.com.renan.services.generic.IGenericService;

/**
@author renan.eliziario
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {


	Cliente buscarPorCPF(Long cpf) throws DAOException;

}
