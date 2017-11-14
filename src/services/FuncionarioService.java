package services;

import javax.persistence.Query;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;
import java.util.*;
import dao.Conexao;
import modelo.Funcionario;


public class FuncionarioService {
	
	public void incluirFuncionario(Funcionario funcionario) {
		
		Conexao.getEme().getTransaction().begin();
		Conexao.getEme().persist(funcionario);
		Conexao.getEme().getTransaction().commit();
        
	}
	
	public void alterarFuncionario(Funcionario funcionario) {
		Conexao.getEme().getTransaction().begin();
		Conexao.getEme().persist(funcionario);
		Conexao.getEme().getTransaction().commit();
	}
	
	public void excluirFuncionario(Funcionario funcionario) {
		Conexao.getEme().getTransaction().begin();
		funcionario = Conexao.getEme().find(Funcionario.class, funcionario.getIdFuncionario());
		Conexao.getEme().remove(funcionario);
		Conexao.getEme().getTransaction().commit();
    }
	
	public Funcionario consultarFuncionarioPorId(Integer id) {
		Funcionario us = Conexao.getEme().find(Funcionario.class, id);
        return us;
	}
	public java.util.List<Funcionario> listarTodosFuncionarios(){
		Query q = Conexao.getEme().createQuery("select f from Funcionario f");
		return q.getResultList();
		
		
	}
	
	public java.util.List<Funcionario> pesquisarFuncionarios(Funcionario funcionario) { 
		String sql = "select * from Funcionario us where 1=1 ";
		
		if (!Validacao.campoVazio(funcionario.getNome_funcionario())){
			sql += " and upper(us.nome) like '%" + funcionario.getNome_funcionario().toUpperCase() + "%'";
		}
		if (!Validacao.campoVazio(funcionario.getLoginFuncionario())){
			sql += " and upper(us.email) like '%" + funcionario.getLoginFuncionario().toUpperCase() + "%'";
		}
			
		Query q = Conexao.getEme().createNativeQuery(sql, Funcionario.class);
		for(Funcionario us : (java.util.List<Funcionario>)q.getResultList()){
			Conexao.getEme().refresh(us);
		}
		
		return q.getResultList();
    }
	
}

