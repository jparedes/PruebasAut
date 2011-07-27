package integration.ui;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Pruebas de integración con Selenium 2.
 * Antes de ejecutar las pruebas es necesario
 * levantar el servidor con la aplicación.
 *
 */
public class UsuarioServiceIntgTest {
	
	private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void crearUsuarioTest() {
		driver.get("http://localhost:8088/PruebasAut/crearUsuario.jsp");
		
		driver.findElement(By.name("login")).sendKeys("usuario");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("email")).sendKeys("email@email.com");
		
		driver.findElement(By.name("submit")).click();
		
		Assert.assertTrue(driver.getPageSource().contains("Usuario creado con �xito"));
	}
	
	@Test
	public void listarUsuarioTest() {
		driver.get("http://localhost:8088/PruebasAut/listarUsuario.action");
		
		List<WebElement> filas = driver.findElements(By.tagName("tr"));
		List<String[]> registros = getRegistrosUsuario(filas);
		
		//registros preparados en la base de datos embebida
		Assert.assertEquals(registros.get(0), new String[] {"1","mkeenan", "s1ng3r", "mkeenan@toolband.com", "1991-12-01 00:00:00.0"});
		Assert.assertEquals(registros.get(1), new String[] {"2","ajones", "gu1t9r1st", "ajones@toolband.com", "1991-12-01 00:00:00.0"});
		Assert.assertEquals(registros.get(2), new String[] {"3","dcarey", "drumm3r", "dcarey@toolband.com", "1991-12-01 00:00:00.0"});
		Assert.assertEquals(registros.get(3), new String[] {"4","jchancellor", "b9ss1st", "jchancellor@toolband.com", "1996-09-17 00:00:00.0"});
		Assert.assertEquals(registros.get(4), new String[] {"5","pdamour", "b9ss1st", "pdamour@lusk.com", "1996-12-01 00:00:00.0"});
	}
	
	private List<String[]> getRegistrosUsuario(List<WebElement> filas) {
		List<String[]> registros = new ArrayList<String[]>();
		
		for (WebElement fila : filas) {
			String[] registro = new String[5];
			int i = 0;
			for (WebElement col : fila.findElements(By.tagName("td"))) {
				registro[i] = col.getText();
				i++;
			}
			registros.add(registro);
		}
		
		registros.remove(0); //la fila de encabezados 
		return registros;
	}
}
