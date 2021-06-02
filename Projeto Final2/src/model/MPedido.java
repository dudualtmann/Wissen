package model;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import control.Pedido;



public class MPedido {
	
	public String errorMsg;
	
	public boolean cadastrar(Pedido p) {
		
		Session session = null;
		try {

			session = HibernateUtil.abrirSession();

			session.save(p);

			session.getTransaction().commit();

			if(session!=null)
				session.close();
			// fechando a conexao
		} catch (HibernateException e) {
			if(session!=null)
				session.close();
			e.printStackTrace();
			errorMsg = e.toString();
			return false;
		}

		return true;
		}
	
	
	
	public boolean update(Pedido p) {
		Session session = null;
		try {

			session = HibernateUtil.abrirSession();

			session.update(p);

			session.getTransaction().commit();

			if(session != null)
				session.close();
			// fechando a conexao
		} catch (HibernateException e) {
			//HibernateUtil.fecharSession();
			if(session != null)
				session.close();
			errorMsg = e.toString();
			return false;
		}

		return true;
	}

}
