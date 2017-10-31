package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the hospede database table.
 * 
 */
@Entity
@NamedQuery(name="Hospede.findAll", query="SELECT h FROM Hospede h")
public class Hospede implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HOSPEDE_IDHOSPEDE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HOSPEDE_IDHOSPEDE_GENERATOR")
	@Column(name="id_hospede")
	private int idHospede;

	private int cpf_hospede;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data_cadastro_hospede;

	private String email_hospede;

	private String nome_hospede;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="hospede")
	private List<Reserva> reservas;

	public Hospede() {
	}

	public int getIdHospede() {
		return this.idHospede;
	}

	public void setIdHospede(int idHospede) {
		this.idHospede = idHospede;
	}

	public int getCpf_hospede() {
		return this.cpf_hospede;
	}

	public void setCpf_hospede(int cpf_hospede) {
		this.cpf_hospede = cpf_hospede;
	}

	public Date getData_cadastro_hospede() {
		return this.data_cadastro_hospede;
	}

	public void setData_cadastro_hospede(Date data_cadastro_hospede) {
		this.data_cadastro_hospede = data_cadastro_hospede;
	}

	public String getEmail_hospede() {
		return this.email_hospede;
	}

	public void setEmail_hospede(String email_hospede) {
		this.email_hospede = email_hospede;
	}

	public String getNome_hospede() {
		return this.nome_hospede;
	}

	public void setNome_hospede(String nome_hospede) {
		this.nome_hospede = nome_hospede;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setHospede(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setHospede(null);

		return reserva;
	}

}