package unit.mock.dao;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import dao.UsuarioDao;

public class UsuarioMockDao implements UsuarioDao{

	private static List<Usuario> usuarios;
	
	static {
		usuarios = new ArrayList<Usuario>();
	}
	
	@Override
	public void crear(Usuario usuario) {
		usuarios.add(usuario);
	}

	@Override
	public List<Usuario> listar() {
		return usuarios;
	}

}
