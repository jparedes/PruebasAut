package service;

import java.util.List;

import model.Usuario;

public interface UsuarioService {
	
	public void crearUsuario(Usuario usuario);
	public String digerirPassword(String fuente);
	public List<Usuario> listarUsuario();

}
