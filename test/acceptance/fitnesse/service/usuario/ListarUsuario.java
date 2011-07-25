package acceptance.fitnesse.service.usuario;

import java.util.List;

import model.Usuario;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.UsuarioService;

import com.om.query.QueryResultBuilder;
import com.om.query.domain.QueryResult;

public class ListarUsuario {
	
	private UsuarioService serv;
	private ClassPathXmlApplicationContext ctx;
	
	public ListarUsuario() {
		ctx = new ClassPathXmlApplicationContext(
				"/acceptance/fitnesse/service/usuario/applicationContext.xml");
		
		serv = (UsuarioService) ctx.getBean("usuarioService");
	}
	
	public List<Object> query() {
		List<Usuario> lista = serv.listarUsuario();
		QueryResultBuilder builder = new QueryResultBuilder(Usuario.class);
		QueryResult result = builder.build(lista.iterator());
		return result.render();
	}
}
