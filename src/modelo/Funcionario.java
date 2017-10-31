package modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the funcionario database table.
 * 
 */
@Entity
@NamedQuery(name="Funcionario.findAll", query="SELECT f FROM Funcionario f")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FUNCIONARIO_IDFUNCIONARIO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FUNCIONARIO_IDFUNCIONARIO_GENERATOR")
	@Column(name="id_funcionario")
	private int idFuncionario;

	@Column(name="login_funcionario")
	private String loginFuncionario;

	private String nome_funcionario;

	@Column(name="senha_funcionario")
	private String senhaFuncionario;

	public Funcionario() {
	}

	public int getIdFuncionario() {
		return this.idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getLoginFuncionario() {
		return this.loginFuncionario;
	}

	public void setLoginFuncionario(String loginFuncionario) {
		this.loginFuncionario = loginFuncionario;
	}

	public String getNome_funcionario() {
		return this.nome_funcionario;
	}

	public void setNome_funcionario(String nome_funcionario) {
		this.nome_funcionario = nome_funcionario;
	}

	public String getSenhaFuncionario() {
		return this.senhaFuncionario;
	}

	public void setSenhaFuncionario(String senhaFuncionario) {
		this.senhaFuncionario = senhaFuncionario;
	}

}