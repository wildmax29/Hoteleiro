package services;

import java.util.List;

import javax.persistence.Query;

import dao.Conexao;
import modelo.Reserva;

public class ReservaService  extends Conexao{
	
	public void incluirReserva(Reserva reserva) throws Exception{
		
		Conexao.getEme().getTransaction().begin();
		Conexao.getEme().persist(reserva);
		Conexao.getEme().getTransaction().commit();
        
	}
	
	public void alterarReserva(Reserva reserva) throws Exception{
		Conexao.getEme().getTransaction().begin();
		Conexao.getEme().merge(reserva);
		Conexao.getEme().getTransaction().commit();
	}
	
	public void excluirReserva(Reserva reserva) throws Exception{
		Conexao.getEme().getTransaction().begin();
		reserva = Conexao.getEme().find(Reserva.class, reserva.getIdReserva());
		Conexao.getEme().remove(reserva);
		Conexao.getEme().getTransaction().commit();
    }
	
	public Reserva consultarReservaPorId(Integer integer) throws Exception{
		Conexao.getEme().getTransaction().begin();
		Reserva reserva = Conexao.getEme().find(Reserva.class, integer);
		Conexao.getEme().getTransaction().commit();
        return reserva;
	}
	
	public List<Reserva> listarTodasReservas() throws Exception{ 
		Query q = Conexao.getEme().createQuery("select c from reserva c");
        return q.getResultList();
	}
	
	
	
}
