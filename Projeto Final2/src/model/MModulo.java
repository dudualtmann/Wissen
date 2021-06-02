package model;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import control.Aula;
import control.Curso;
import control.Modulo;

public class MModulo {

	public String errorMsg;

	public boolean cadastrar(Modulo m) {

		Session session = null;
		try {

			session = HibernateUtil.abrirSession();

			session.save(m);

			session.getTransaction().commit();

			if (session != null)
				session.close();
			// fechando a conexao
		} catch (HibernateException e) {
			if (session != null)
				session.close();
			errorMsg = e.toString();
			return false;
		}

		return true;

	}

	public Modulo findModulo(Modulo m) {

		Session session = null;

		try {
			session = HibernateUtil.abrirSession();

			m = session.find(Modulo.class, m.getId());

			session.getTransaction().commit();

			if (session != null)
				session.close();
		} catch (HibernateException e) {
			errorMsg = e.toString();
			return null;
		}

		return m;

	}

	public List<Modulo> searchModulos(Curso c) {
		// User contem 'arg' -- usar SELECT * FROM users WHERE nome LIKE '%arg%'
		Session session = null;
		List<Modulo> list = null;

		try {

			session = HibernateUtil.abrirSession();

			String sql = "FROM Modulo m  WHERE curso_id = :id";

			Query query = session.createQuery(sql, Modulo.class);

			query.setParameter("id", c.getId());

			list = query.getResultList();

			session.getTransaction().commit();

			if (session != null)
				session.close();

			if (list == null || list.isEmpty()) {
				errorMsg = "Não Foi encontrado nenhum Módulo no Curso";
				return null;
			}
			// fechando a conexao
		} catch (HibernateException e) {
			if (session != null)
				session.close();
			errorMsg = e.toString();
			return null;
		}

		return list;

	}
	
	public List<Aula> pegarAulas(Modulo m) {
		Session session = null;
		List<Aula> list = null;

		try {
			
			
			
			session = HibernateUtil.abrirSession();
	        
	        String sql = "FROM Aula a  WHERE modulo_id = :id";
	        Query query = session.createQuery(sql);
	        
	        query.setParameter("id", m.getId());
	        
	        list = (List<Aula>) query.getResultList();
	        
	        session.getTransaction().commit();
	        
	        if(session != null)
				session.close();
	        
	        if(list==null ||list.isEmpty()) {
	        	errorMsg = "Não foram encontradas aulas nesse módulo";
	        	return null;
	        }
	        // fechando a conexao
			} catch( HibernateException e ) {
				if(session != null)
					session.close();
				errorMsg = e.toString();
				return null;
			}
		
		return list;

	}

}
