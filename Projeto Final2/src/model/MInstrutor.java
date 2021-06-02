package model;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import control.Instrutor;

public class MInstrutor {
	
	public String errorMsg;
	
public boolean cadastrar(Instrutor i) {
		
		Session session = null;
		try {

			session = HibernateUtil.abrirSession();

			session.save(i);

			session.getTransaction().commit();

			if(session!=null)
				session.close();
			// fechando a conexao
		} catch (HibernateException e) {
			if(session!=null)
				session.close();
			errorMsg = e.toString();
			return false;
		}

		return true;

		
	}
	
	public Instrutor login(String email, String senha) {
		// Método para verificar se o login (user e senha) estão corretos.
		Session session = null;
		Instrutor s = null;
		try {
			// pegando as configurações na session factory do arquivo hibernate.cfg.xml

			session = HibernateUtil.abrirSession();

			String sql = "FROM instrutores WHERE email = :email AND senha = :senha AND accStatus = 0";
			Query query = session.createQuery(sql);

			query.setParameter("email", email);
			query.setParameter("senha", senha);

			s = (Instrutor) query.getSingleResult();

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
			errorMsg = "Email e/ou Senha inválido(s)";
			return null;
		}

		return s;
	}
	
	public Instrutor findUser(Instrutor user) {
		// Método para Verificar se ja existe um usuário com tal email

		Session session = null;
		Instrutor i = null;
		try {

			session = HibernateUtil.abrirSession();

			String sql = "FROM instrutores WHERE email = :email AND accStatus = 0 OR accStatus = 2";
			Query query = session.createQuery(sql);

			query.setParameter("email", user.getEmail());

			i = (Instrutor) query.getSingleResult();

			session.getTransaction().commit();

			if(session != null)
				session.close();
			
		} catch (HibernateException e) {
			if(session != null)
				session.close();
			errorMsg = e.toString();
			return null;
		}
		catch(NoResultException e) {
			if(session != null)
				session.close();
			errorMsg = "Instrutor inválido";
			return null;
		}
		
		if(i == null) {
			errorMsg = "Erro ao Localizar Instrutor";
			return null;
		}

		return i;
	}
	
	public List<Instrutor> searchInstrutores(String arg) {
		// User contem 'arg' -- usar SELECT * FROM users WHERE nome LIKE '%arg%'
		Session session = null;
		List<Instrutor> list = null;

		try {
			
			
			
			session = HibernateUtil.abrirSession();
	        
	        String sql = "FROM instrutores  WHERE nome LIKE '%"+arg+"%'";
	        
	        list = session.createQuery(sql,Instrutor.class).getResultList();
	        
	        session.getTransaction().commit();
	        
	        if(session != null)
				session.close();
	        
	        if(list==null ||list.isEmpty()) {
	        	errorMsg = "Não Foi encontrado nenhum Instrutor similar a '"+arg+"', verifique se o nome foi digitado corretamente";
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
	
	public boolean update(Instrutor i) {
		Session session = null;
		try {

			session = HibernateUtil.abrirSession();

			session.update(i);

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
	
	public boolean delInstrutor(Instrutor i) {
		Session session = null;
		try {
			
			session = HibernateUtil.abrirSession();
			
			String sql = "UPDATE instrutores SET accStatus = 1 WHERE id = :id";
			
			Query query = session.createQuery(sql);

			query.setParameter("id",i.getId());
			
			query.executeUpdate();
			
			session.getTransaction().commit();
			
			
			if(session != null)
				session.close();
			
		}catch(HibernateException e) {
			if(session != null)
				session.close();
			errorMsg = e.toString();
			return false;
		} catch(NoResultException e) {
			if(session != null)
				session.close();
			errorMsg = "Instrutor inválido";
			return false;
		}
		
		return true;
		
	}
	
	public boolean desativarInstrutor(Instrutor i) {
		Session session = null;
		try {
			
			session = HibernateUtil.abrirSession();
			
			String sql = "UPDATE instrutores SET accStatus = 2 WHERE id = :id";
			
			Query query = session.createQuery(sql);

			query.setParameter("id",i.getId());
			query.executeUpdate();
			
			session.getTransaction().commit();
			
			
			if(session != null)
				session.close();
			
		}catch(HibernateException e) {
			if(session != null)
				session.close();
			errorMsg = e.toString();
			return false;
		} catch(NoResultException e) {
			if(session != null)
				session.close();
			errorMsg = "Instrutor inválido";
			return false;
		}
		
		return true;
		
	}
	

}
