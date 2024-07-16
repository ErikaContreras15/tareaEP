package ec.edu.ups.demoJakartaa.business;

import java.util.List;

import ec.edu.ups.demoJakartaa.dao.ClienteDAO;
import ec.edu.ups.demoJakartaa.modelo.Cliente;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionUsuario {
	@Inject
	private ClienteDAO daoCliente;   
	
	@PostConstruct
	public void init() {
		
		System.out.println("Hola Mundo EJB");
		
		
		Cliente cliente  = new Cliente();
		cliente.setCedula("0106333922");
		cliente.setNombre("Nataly Contreras");
		cliente.setDireccion("Giron");
		
		daoCliente.insert(cliente);
		
		
		List<Cliente> listado = daoCliente.getAll();
		for(Cliente cli: listado) {
			System.err.println(cli.getCedula() + " " + cli.getNombre()+ " " + cli.getDireccion());
		}    
	}

}
