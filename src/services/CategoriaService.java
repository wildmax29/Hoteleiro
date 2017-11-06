package services;

import java.util.List;

import javax.persistence.Query;

import dao.Conexao;
import modelo.Categoria;

public class CategoriaService  extends Conexao{
	
	public void incluirCategoria(Categoria categoria) throws Exception{
		
		Conexao.getEme().getTransaction().begin();
		Conexao.getEme().persist(categoria);
		Conexao.getEme().getTransaction().commit();
        
	}
	
	public void alterarCategoria(Categoria categoria) throws Exception{
		Conexao.getEme().getTransaction().begin();
		Conexao.getEme().merge(categoria);
		Conexao.getEme().getTransaction().commit();
	}
	
	public void excluirCategoria(Categoria categoria) throws Exception{
		Conexao.getEme().getTransaction().begin();
		categoria = Conexao.getEme().find(Categoria.class, categoria.getIdCategoria());
		Conexao.getEme().remove(categoria);
		Conexao.getEme().getTransaction().commit();
    }
	
	public Categoria consultarCategoriaPorId(Integer integer) throws Exception{
		Conexao.getEme().getTransaction().begin();
		Categoria quartoCategoria = Conexao.getEme().find(Categoria.class, integer);
		Conexao.getEme().getTransaction().commit();
        return quartoCategoria;
	}
	
	public List<Categoria> listarTodasCategorias() throws Exception{ 
		Query q = Conexao.getEme().createQuery("select c from Categoria c");
        return q.getResultList();
	}
	
	
	
}
