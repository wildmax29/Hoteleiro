package services;

import java.util.List;

import javax.persistence.Query;

import dao.Conexao;
import modelo.Quarto;

public class QuartoService  extends Conexao{
	
	public void incluirQuarto(Quarto quarto) throws Exception{
		
		Conexao.getEme().getTransaction().begin();
		Conexao.getEme().persist(quarto);
		Conexao.getEme().getTransaction().commit();
        
	}
	
	public void alterarQuarto(Quarto quarto) throws Exception{
		Conexao.getEme().getTransaction().begin();
		Conexao.getEme().merge(quarto);
		Conexao.getEme().getTransaction().commit();
	}
	
	public void excluirQuarto(Quarto quarto) throws Exception{
		Conexao.getEme().getTransaction().begin();
		quarto = Conexao.getEme().find(Quarto.class, quarto.getIdQuarto());
		Conexao.getEme().remove(quarto);
		Conexao.getEme().getTransaction().commit();
    }
	
	public Quarto consultarQuartoPorId(Integer integer) throws Exception{
		Conexao.getEme().getTransaction().begin();
		Quarto quarto= Conexao.getEme().find(Quarto.class, integer);
		Conexao.getEme().getTransaction().commit();
        return quarto;
	}
	
	public List<Quarto> listarTodosQuartos() throws Exception{ 
		Query q = Conexao.getEme().createQuery("select t from Quarto t");
        return q.getResultList();
	}
	
	
	
}
