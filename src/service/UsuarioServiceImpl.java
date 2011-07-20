package service;

import java.util.Date;
import java.util.List;

import dao.UsuarioDao;

import model.Usuario;

public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioDao dao;

	@Override
	public void crearUsuario(Usuario usuario) {
		usuario.setId(null);
		usuario.setFechaRegistro(new Date());
		dao.crear(usuario);
	}

	@Override
	public List<Usuario> listarUsuario() {
		return dao.listar();
	}

	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}

}
