package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static Session session;
	public static String erro = null;

	public static Session abrirSession() {
		try {
			SessionFactory sessionFactory;
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			if(!session.getTransaction().isActive())
			session.beginTransaction();
			return session;
		} catch (Throwable e) {
			erro = e.toString();
			System.out.println(erro);
			return null;
		}
	}


}
