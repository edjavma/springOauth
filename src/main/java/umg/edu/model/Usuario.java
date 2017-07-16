package umg.edu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name="Usuario.listar",
				query="SELECT u FROM Usuario u "),
	@NamedQuery(name="Usuario.find",
				query="SELECT u FROM Usuario u WHERE u.codigoUsuario = :codigo "),
	@NamedQuery(name="Usuario.findByUsername",
				query="SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombre"),
	@NamedQuery(name="Usuario.correlativo",
				query="SELECT MAX(u.codigoUsuario) FROM Usuario u ")
})
@Table(name="usuario")
public class Usuario {

	@Id
	@Column(name="codigo_usuario")
	private Integer codigoUsuario;
	
	@Column(name="nombre_usuario")
	private String nombreUsuario;
	
	@Column(name="password")
	private String password;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="direccion")
	private String direccion;

	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
