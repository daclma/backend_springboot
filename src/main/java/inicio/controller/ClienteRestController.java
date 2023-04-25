package inicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import inicio.models.entity.Cliente;
import inicio.models.services.IClienteService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins= {"http://localhost:4200"})
public class ClienteRestController {

	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> listaClientes(){
		return clienteService.findAll();
	}
	
	@GetMapping("/clientes/{idCliente}")
	public Cliente findCliente(@PathVariable Long idCliente) {
		return clienteService.findById(idCliente);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)//Hace que el estado de la response al llamar aqui sea 201.
	public Cliente saveCliente(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}
	
	@PutMapping("/clientes/{idCliente}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente updateCliente(@RequestBody Cliente cliente, @PathVariable Long idCliente) {
		Cliente clienteEncontrado = clienteService.findById(idCliente);

		clienteEncontrado.setNombre(cliente.getNombre());
		clienteEncontrado.setApellidos(cliente.getApellidos());
		clienteEncontrado.setEmail(cliente.getEmail());
		
		clienteService.save(clienteEncontrado);
		
		return clienteEncontrado;
	}
	
	@DeleteMapping("/clientes/{idCliente}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCliente(@PathVariable Long idCliente) {
		clienteService.delete(idCliente);
	}
}
