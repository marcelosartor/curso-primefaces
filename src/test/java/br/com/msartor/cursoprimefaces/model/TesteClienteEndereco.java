package br.com.msartor.cursoprimefaces.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TesteClienteEndereco {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CURSO-PRIMEFACES");
		EntityManager manager = factory.createEntityManager();
	
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		Cliente cliente = new Cliente();
		cliente.setNome("João das Couves");
		cliente.setEmail("joao@dascouves.com");
		cliente.setDocumentoReceitaFederal("123.123.123-12");
		cliente.setTipo(TipoPessoa.FISICA);
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua das Aboboras Verdes");
		endereco.setNumero("111");
		endereco.setCidade("Tubarão");
		endereco.setUf("SC");
		endereco.setCep("88700-001");
		endereco.setCliente(cliente);
		
		cliente.getEnderecos().add(endereco);
		
		manager.persist(cliente);
				
		trx.commit();
	}
}
