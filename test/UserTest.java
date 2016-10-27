
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import persistent.User;
public class UserTest {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	@Before
	public void init()
	{
		//build configuration
		Configuration config = new Configuration().configure();
		//Build service resistry
		ServiceRegistry service = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//Build session factory
		sessionFactory = config.buildSessionFactory(service);
		session = sessionFactory.openSession();
		//open transaction
		transaction = session.beginTransaction();
	}
	
	@After
	public void destroy()
	{
		transaction.commit();
		session.close();
		sessionFactory.close();
		
	}
	@Test
	public void testUser(){
		//Initialize a User
		User user = new User("Frankybaby123", "Franky","Lando");
		session.save(user);
	}
}
