package dao;

import java.util.List;

import model.User;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Repository;

public class HibernateDao {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	private int pageCount;
	private int pageSize ;
	/**
	 * 
	 * @param username
	 * @param password
	 * @return user
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

		session.getTransaction().commit();

		return list;
		
	}

	/**
	 * @author suzhantao
	 * @param user
	 *            : user instance 哈哈
	 * @return obj: save的返回值为一个obj，用来判断是否save成功
	 */
	public Object save(User user) {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Object obj = session.save(user);

		session.getTransaction().commit();

		return obj;

	}
	
	/**
	 * 
	 * @return
	 */
	public int SearchPageCount(int pageSize) {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		List list = session.createQuery("from User").list();

		session.getTransaction().commit();

		int rowCount = list.size();

		if (rowCount % pageSize == 0) {
			pageCount = rowCount / pageSize;
		} else {
			pageCount = rowCount / pageSize + 1;
		}

		return pageCount;

	}
	
	
	
	/**
	 * Paging
	 * 
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	public List searchPage(int pageNow, int pageSize) {
		Configuration configuration = new Configuration();
		configuration.configure();

		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		List list = session.createQuery("from User")
				.setFirstResult(pageSize * (pageNow - 1))
				.setMaxResults(pageSize).list();

		session.getTransaction().commit();

		return list;
	}

}
