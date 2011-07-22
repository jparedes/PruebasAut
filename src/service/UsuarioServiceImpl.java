package service;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import model.Usuario;
import dao.UsuarioDao;

public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioDao dao;

	@Override
	public void crearUsuario(Usuario usuario) {
		usuario.setId(null);
		usuario.setPassword(digerirPassword(usuario.getPassword()));
		usuario.setFechaRegistro(new Date());
		dao.crear(usuario);
	}
	
	@Override
	public String digerirPassword(String fuente) {
		return DigestUtils.md5Hex("sal" + fuente + "pimienta");
	}

	@Override
	public List<Usuario> listarUsuario() {
		return dao.listar();
	}

	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}
}
