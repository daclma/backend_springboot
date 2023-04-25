package inicio.models.dao;

import org.springframework.data.repository.CrudRepository;

import inicio.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

}
