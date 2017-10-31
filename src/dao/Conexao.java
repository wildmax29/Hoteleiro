package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Conexao {

	private static EntityManagerFactory factory;
	public static EntityManager em; 
	
	public static EntityManager getEme() {
		if (em == null){
			getConexao();
		}
		return em;
	}
	
	public static EntityManager getConexao() {
		
		if (factory == null){
			factory = Persistence.createEntityManagerFactory("hoteleiro");
			em = factory.createEntityManager();
		}
		
		return em;
	}
    
}
