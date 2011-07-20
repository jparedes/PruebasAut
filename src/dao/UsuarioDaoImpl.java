package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import model.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {
	
	private HibernateTemplate hbTmp;
	
	public void setSessionFactory(SessionFactory sessionFact) {
		this.hbTmp = new HibernateTemplate(sessionFact);
	}

	@Override
	public void crear(Usuario usuario) {
		hbTmp.save(usuario);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listar() {
		return (List<Usuario>)hbTmp.find("from Usuario");
	}

}
