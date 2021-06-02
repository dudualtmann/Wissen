package model;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import control.Aula;

public class MAula {
	
	public String errorMsg;
	
	public boolean cadastrar(Aula a) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.abrirSession();
			
			session.save(a);
			
			session.getTransaction().commit();
			
			if(session != null) 
				session.close();
			
		} catch(HibernateException e) {
			
			errorMsg = e.toString();
			return false;
		}
		
		return true;
		
	}

}
