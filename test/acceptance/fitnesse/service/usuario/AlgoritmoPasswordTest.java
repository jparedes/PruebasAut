package acceptance.fitnesse.service.usuario;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.UsuarioService;

public class AlgoritmoPasswordTest {
	
	private ClassPathXmlApplicationContext ctx;
	private UsuarioService serv;
	
	private String fuente;
	
	public AlgoritmoPasswordTest() {
		ctx = new ClassPathXmlApplicationContext(
				"/acceptance/fitnesse/service/usuario/applicationContext.xml");
		
		serv = (UsuarioService) ctx.getBean("usuarioService");
	}
	
	public String password() {
		return serv.digerirPassword(fuente);
	}
	
	public void setFuente(String fuente) {
		this.fuente = fuente;
	}
}
