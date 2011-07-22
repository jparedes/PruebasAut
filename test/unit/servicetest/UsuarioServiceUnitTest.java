package unit.servicetest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import service.UsuarioServiceImpl;

public class UsuarioServiceUnitTest {
	
	private UsuarioServiceImpl serv;
	
	@BeforeTest
	public void setUp() {
		serv = new UsuarioServiceImpl();
	}
	
	@DataProvider(name="passwordsPrueba")
	public Iterator<String[]> passwordsPrueba() {
		List<String[]> data = new ArrayList<String[]>();
		
		data.add(new String[] {"lechuga", "c50abf9007dbec9629861217b493648a"});
		data.add(new String[] {"tomate",  "6d6e42ae94a124d7f0a438c265f30bd7"});
		data.add(new String[] {"albahaca","a91292ec141ab312a6f5d42fb7e4abcb"});
		
		return data.iterator();
		
	}
	
	@Test(dataProvider="passwordsPrueba")
	public void digerirPasswordTest(String password, String passwordDig) {
		String resultado = serv.digerirPassword(password);
		Assert.assertEquals(resultado, passwordDig);
	}

}
