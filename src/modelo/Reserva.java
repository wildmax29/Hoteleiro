package modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reserva database table.
 * 
 */
@Entity
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESERVA_IDRESERVA_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESERVA_IDRESERVA_GENERATOR")
	@Column(name="id_reserva")
	private int idReserva;

	//bi-directional many-to-one association to Hospede
	@ManyToOne
	@JoinColumn(name="hospede_fk")
	private Hospede hospede;

	//bi-directional many-to-one association to Notafiscal
	@ManyToOne
	@JoinColumn(name="notafiscal_fk")
	private Notafiscal notafiscal;

	//bi-directional many-to-one association to Quarto
	@ManyToOne
	@JoinColumn(name="quarto_fk")
	private Quarto quarto;

	public Reserva() {
	}

	public int getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Hospede getHospede() {
		return this.hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	public Notafiscal getNotafiscal() {
		return this.notafiscal;
	}

	public void setNotafiscal(Notafiscal notafiscal) {
		this.notafiscal = notafiscal;
	}

	public Quarto getQuarto() {
		return this.quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

}