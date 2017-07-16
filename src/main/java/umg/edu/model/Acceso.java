package umg.edu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name="Acceso.listarPorUsuario",
				query="SELECT a FROM Acceso a WHERE a.codigoUsuario.codigoUsuario = :codigo "),
	@NamedQuery(name="Acceso.correlativo",
				query="SELECT MAX(a.correlativo) FROM Acceso a ")
})
@Table(name="acceso")
public class Acceso {
	
	@Id
	@Column(name="correlativo")
	private Integer correlativo;
	
	@ManyToOne
	@JoinColumn(name="codigo_usuario")
	private Usuario codigoUsuario;
	
	@ManyToOne
	@JoinColumn(name="codigo_rol")
	private Rol codigoRol;

	public Integer getCorrelativo() {
		return correlativo;
	}

	public void setCorrelativo(Integer correlativo) {
		this.correlativo = correlativo;
	}

	public Rol getCodigoRol() {
		return codigoRol;
	}

	public void setCodigoRol(Rol codigoRol) {
		this.codigoRol = codigoRol;
	}

	public Usuario getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Usuario codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	
	
}
