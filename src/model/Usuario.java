package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.xwork.builder.EqualsBuilder;


@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="login")
	private String login;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="fecha_registro")
	private Date fechaRegistro;
	
	public Usuario(){
	}
	
	public Usuario(String login, String password, String email) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			EqualsBuilder builder = new EqualsBuilder();
			final Usuario ref = (Usuario)obj;
			builder.append(id, ref.id);
			builder.append(login, ref.login);
			builder.append(password, ref.password);
			builder.append(email, ref.email);
			return builder.isEquals();
		}
		return false;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	

}
