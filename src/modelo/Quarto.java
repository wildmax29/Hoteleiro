package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the quarto database table.
 * 
 */
@Entity
@NamedQuery(name="Quarto.findAll", query="SELECT q FROM Quarto q")
public class Quarto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="QUARTO_IDQUARTO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="QUARTO_IDQUARTO_GENERATOR")
	@Column(name="id_quarto")
	private int idQuarto;

	@Column(name="numero_quarto")
	private int numeroQuarto;

	@Column(name="status_quarto")
	private byte statusQuarto;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="categoria_id_fk")
	private Categoria categoria;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="quarto")
	private List<Reserva> reservas;

	public Quarto() {
	}

	public int getIdQuarto() {
		return this.idQuarto;
	}

	public void setIdQuarto(int idQuarto) {
		this.idQuarto = idQuarto;
	}

	public int getNumeroQuarto() {
		return this.numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public byte getStatusQuarto() {
		return this.statusQuarto;
	}

	public void setStatusQuarto(byte statusQuarto) {
		this.statusQuarto = statusQuarto;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setQuarto(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setQuarto(null);

		return reserva;
	}

}