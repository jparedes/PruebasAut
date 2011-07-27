package unit.service.usuario;

import model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import service.UsuarioService;
import unit.mock.dao.UsuarioMockDao;
import unit.testdata.UsuarioServiceTestData;

@ContextConfiguration(locations="classpath:/unit/service/usuario/applicationContext-unitTest.xml")
public class UsuarioServiceUnitTest extends AbstractTestNGSpringContextTests {
	
	@Autowired
	private UsuarioService serv;
	
	@Test(dataProvider="passwordsPrueba", dataProviderClass=UsuarioServiceTestData.class)
	public void digerirPasswordTest(String password, String passwordDig) {
		String resultado = serv.digerirPassword(password);
		Assert.assertEquals(resultado, passwordDig);
	}
	
	@Test
	public void crearUsuarioTest() {
		//Arrange
		UsuarioMockDao dao = new UsuarioMockDao();
		Usuario referencia = new Usuario("login",
				"c50abf9007dbec9629861217b493648a",
				"login@email.com");
		
		//Act
		serv.crearUsuario(new Usuario("login","lechuga","login@email.com"));
		
		//Assert
		Usuario resultado = dao.listar().get(0);
		Assert.assertTrue(referencia.equals(resultado));
	}
}
