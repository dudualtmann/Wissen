package model;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import control.Carrinho;

public class MCarrinho {

	public String errorMsg;

	public boolean cadastrar(Carrinho c) {

		Session session = null;
		try {

			session = HibernateUtil.abrirSession();

			session.save(c);

			session.getTransaction().commit();

			if (session != null)
				session.close();
			// fechando a conexao
		} catch (HibernateException e) {
			if (session != null)
				session.close();
			e.printStackTrace();
			errorMsg = e.toString();
			return false;
		}

		return true;
	}
	
	public Carrinho find(Carrinho c) {
		
		Session session = null;
		Carrinho c2 = null;
		try {
			// pegando as configurações na session factory do arquivo hibernate.cfg.xml

			session = HibernateUtil.abrirSession();

			String sql = "FROM Carrinho c WHERE id_aluno = :id";
			Query query = session.createQuery(sql);

			query.setParameter("id", c.getId());

			c2 = (Carrinho) query.getSingleResult();

			session.getTransaction().commit();

			if(session != null)
				session.close();

		} catch (HibernateException e) {
			if(session != null)
				session.close();
			errorMsg = e.toString();
			return null;
		} catch (NoResultException e) {
			if(session != null)
				session.close();
			errorMsg = "Esse usuário não possui um carrinho.";
			return null;
		}

		return c2;
		
	}

	public boolean update(Carrinho c) {
		Session session = null;
		try {

			session = HibernateUtil.abrirSession();

			session.update(c);

			session.getTransaction().commit();

			if (session != null)
				session.close();
			// fechando a conexao
		} catch (HibernateException e) {
			// HibernateUtil.fecharSession();
			if (session != null)
				session.close();
			errorMsg = e.toString();
			return false;
		}

		return true;
	}

}
