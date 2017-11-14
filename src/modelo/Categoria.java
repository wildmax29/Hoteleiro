package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CATEGORIA_IDCATEGORIA_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATEGORIA_IDCATEGORIA_GENERATOR")
	@Column(name="id_categoria")
	private int idCategoria;

	@Column(name="nome_categoria")
	private String nomeCategoria;

	@Column(name="preco_categoria")
	private float precoCategoria;

	//bi-directional many-to-one association to Quarto
	@OneToMany(mappedBy="categoria",orphanRemoval=true)
	private List<Quarto> quartos;

	public Categoria() {
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return this.nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public float getPrecoCategoria() {
		return this.precoCategoria;
	}

	public void setPrecoCategoria(float precoCategoria) {
		this.precoCategoria = precoCategoria;
	}

	public List<Quarto> getQuartos() {
		return this.quartos;
	}

	public void setQuartos(List<Quarto> quartos) {
		this.quartos = quartos;
	}

	public Quarto addQuarto(Quarto quarto) {
		getQuartos().add(quarto);
		quarto.setCategoria(this);

		return quarto;
	}

	public Quarto removeQuarto(Quarto quarto) {
		getQuartos().remove(quarto);
		quarto.setCategoria(null);

		return quarto;
	}

}