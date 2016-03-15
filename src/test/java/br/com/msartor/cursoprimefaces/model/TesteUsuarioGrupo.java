package br.com.msartor.cursoprimefaces.model;

import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TesteUsuarioGrupo {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CURSO-PRIMEFACES");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = manager.getTransaction();
		
		trx.begin();
		
		Grupo grupo = new Grupo();
		grupo.setNome("Vendedores");
		grupo.setDescricao("Vendedores da empresa");
		manager.persist(grupo);
		
		Grupo grupo2 = new Grupo();
		grupo2.setNome("Compradores");
		grupo2.setDescricao("Compradores da empresaa");
		manager.persist(grupo2);
		
		for(int i=1;i<=3;i++){
			Usuario usuario = new Usuario();
			usuario.setNome("Maria "+i);
			usuario.setEmail("maria@abadia.com"+i);
			usuario.setSenha("123");
			if(i==1){			
				usuario.getGrupos().add(grupo);
			}else{
				for(int y=1;y<=2;y++){
					if(y==1)
						usuario.getGrupos().add(grupo);
					else
						usuario.getGrupos().add(grupo2);
				}
			}
			manager.persist(usuario);
		}
		
		
				
		
		
		trx.commit();
		
	}
}
