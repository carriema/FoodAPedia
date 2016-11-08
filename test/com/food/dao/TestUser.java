package com.food.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.food.domain.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:restaurantsearch.xml"})
public class TestUser {
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testGetMatchCount() {
		boolean isExist = userDao.getMatchCount("wendy","0000") >= 1;
		assertTrue(isExist);
		boolean isNotExist = userDao.getMatchCount("clinton", "0912") >= 1;
		assertTrue(!isNotExist);
	}
	
	@Test
	public void testFindUserByserAccount() {
		User user = userDao.findUserByserAccount("wendy");
		assertEquals(user.getFirstName(),"Liyan");
	}
	@Test
	public void save() {
		User user = new User();
		user.setUserAccount("erha");
		user.setFirstName("yanyan");
		user.setLastName("xiao");
		user.setLastVisit(new Date());
		userDao.save(user);
	}
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
