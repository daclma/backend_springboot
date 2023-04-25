package inicio.models.services;

import java.util.List;

import inicio.models.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();

	public Cliente findById(Long idCliente);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long idCliente);
}
