package service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class TestUserService {

	
	@Autowired
	private UserService userService;
	
	@Test
	public void hasMatchUser() {
		boolean b1 = userService.hasMatch("wendy", "0000");
		boolean b2 = userService.hasMatch("Shile","1921");
		System.out.println(b1);
		assertTrue(b1);
		assertTrue(!b2);
	}
	@Test
	public void findUserByUserName() {
		User user = userService.findUserByName("wendy");
		assertEquals(user.getLastName(),"Huang");
		userService.loginSuccess(user);
	}
	
	
	//@Test
	//public void test() {
	//	fail("Not yet implemented");
	//}

}
