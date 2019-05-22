package accountapplicationtesting;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import Service.Service;
import domain.Account;

public class appTest {
	
	private static Service serv = Service.getInstance();
	private static Account acc;
	
	@BeforeClass
	public static void setup() {
		serv.addAccountToMap(new Account("John", "Smith", 1));
		serv.addAccountToMap(new Account("John", "Gordon", 2));
		serv.addAccountToMap(new Account("Jordan", "Smith", 3));
		acc = new Account("John", "Peters", 4);
		serv.addAccountToMap(acc);
	}
	
	@Test
	public void accountCountTest() {
		int exp = 3;
		int test = serv.countAccounts("John");
		assertEquals(exp, test);
	}
	
	
	@Test
	public void accountReturnTest() {
		String exp = "{\"1\":{\"firstName\":\"John\",\"lastName\":\"Smith\",\"accountNumber\":1},\"2\":{\"firstName\":\"John\",\"lastName\":\"Gordon\",\"accountNumber\":2},\"3\":{\"firstName\":\"Jordan\",\"lastName\":\"Smith\",\"accountNumber\":3},\"4\":{\"firstName\":\"John\",\"lastName\":\"Peters\",\"accountNumber\":4}}";
		String test = serv.returnAccounts();
		assertEquals(exp, test);
	}
	
	@Test
	public void accountReturnOneTest() {
		Account test = serv.retrieveAccount(4);
		assertEquals(acc, test);
	}
}
