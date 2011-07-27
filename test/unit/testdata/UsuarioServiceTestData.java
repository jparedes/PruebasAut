package unit.testdata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

public class UsuarioServiceTestData {
	
	@DataProvider(name="passwordsPrueba")
	public static Iterator<String[]> passwordsPrueba() {
		List<String[]> data = new ArrayList<String[]>();
		
		data.add(new String[] {"lechuga", "c50abf9007dbec9629861217b493648a"});
		data.add(new String[] {"tomate",  "6d6e42ae94a124d7f0a438c265f30bd7"});
		data.add(new String[] {"albahaca","a91292ec141ab312a6f5d42fb7e4abcb"});
		
		return data.iterator();
	}
}
