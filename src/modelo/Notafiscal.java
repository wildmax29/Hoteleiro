package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the notafiscal database table.
 * 
 */
@Entity
@NamedQuery(name="Notafiscal.findAll", query="SELECT n FROM Notafiscal n")
public class Notafiscal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NOTAFISCAL_IDNOTAFISCAL_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOTAFISCAL_IDNOTAFISCAL_GENERATOR")
	@Column(name="id_notafiscal")
	private int idNotafiscal;

	private String operacao_notafiscal;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="notafiscal")
	private List<Reserva> reservas;

	public Notafiscal() {
	}

	public int getIdNotafiscal() {
		return this.idNotafiscal;
	}

	public void setIdNotafiscal(int idNotafiscal) {
		this.idNotafiscal = idNotafiscal;
	}

	public String getOperacao_notafiscal() {
		return this.operacao_notafiscal;
	}

	public void setOperacao_notafiscal(String operacao_notafiscal) {
		this.operacao_notafiscal = operacao_notafiscal;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setNotafiscal(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setNotafiscal(null);

		return reserva;
	}

}