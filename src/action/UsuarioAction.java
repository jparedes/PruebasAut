package action;

import java.util.List;

import model.Usuario;
import service.UsuarioService;

public class UsuarioAction {
	
	private UsuarioService servicio;
	
	private String login;
	private String password;
	private String email;
	private List<Usuario> usuarios;
	
	public String crearUsuario() {
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setPassword(password);
		usuario.setEmail(email);
		
		servicio.crearUsuario(usuario);
		
		return "success";
	}
	
	public String listarUsuario() {
		usuarios = servicio.listarUsuario();		
		return "success";
	}
	
	

	public UsuarioService getServicio() {
		return servicio;
	}

	public void setServicio(UsuarioService servicio) {
		this.servicio = servicio;
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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
