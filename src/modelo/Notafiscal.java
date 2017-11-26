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
	//@OneToOne
	//private Reserva reserva;
	@ManyToOne
	@JoinColumn(name="reserva_fk")
	private Reserva reserva;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="notaFiscal")
	private Reserva Reserva;

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

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}