package dao;

import java.util.List;

import model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateDao {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public List searchUser(String username) {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		System.out.println("sessionFactory establish");

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		String hql = " from User where name like :name";
		Query query = session.createQuery(hql);
		query.setString("name", username);
		List<User> list = query.list();

		// List<User> list = session.createQuery("from User").list();

		session.getTransaction().commit();

		return list;

	}

}
