package services;

import java.util.List;
import javax.persistence.Query;
import modelo.*;
import dao.Conexao;

public class HospedeService {
	
	public void IncluirHospede(Hospede hospede) {
		Conexao.getEme().getTransaction().begin();
		Conexao.getEme().persist(hospede);
		Conexao.getEme().getTransaction().commit();
		
	}

		public void alterarHospede(Hospede hospede){
		Conexao.getEme().getTransaction().begin();
		Conexao.getEme().merge(hospede);
		Conexao.getEme().getTransaction().commit();
	}

	public void excluirHospede(Hospede hospede){
		Conexao.getEme().getTransaction().begin();
		hospede = Conexao.getEme().find(Hospede.class, hospede.getIdHospede());
		Conexao.getEme().remove(hospede);
		Conexao.getEme().getTransaction().commit();
	}

	public Hospede consultarHospedePorId(Integer id){
		Hospede h = Conexao.getEme().find(Hospede.class, id);
		return h;
	}

	public java.util.List<Hospede> listarTodosHospede(){
		Query h = Conexao.getEme().createQuery("select h from Hospede h");
		return h.getResultList();
	}
	
	public List<Hospede> pesquisarHospedes(Hospede hospede) { 
		String sql = "select * from hospede h where 1=1 ";
		
		
			sql += " and upper(h.nome) like '%" + hospede.getNome_hospede()+ "%'";
				
			sql += " and upper(h.email) like '%" + hospede.getEmail_hospede() + "%'";
		
		
		//teste
		Query q = Conexao.getEme().createNativeQuery(sql, Hospede.class);
		for(Hospede h : (List<Hospede>)q.getResultList()){
			Conexao.getEme().refresh(h);
		}
		
		return q.getResultList();
    }
	
}
