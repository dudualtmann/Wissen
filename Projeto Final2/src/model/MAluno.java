package model;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import control.Aluno;
import control.Pedido;

public class MAluno {
	
public String errorMsg;
	
	public Aluno login(String email, String senha) {
		// Método para verificar se o login (user e senha) estão corretos.
		Session session = null;
		Aluno s = null;
		try {
			// pegando as configurações na session factory do arquivo hibernate.cfg.xml

			session = HibernateUtil.abrirSession();

			String sql = "FROM alunos WHERE email = :email AND senha = :senha AND accStatus = 0";
			Query query = session.createQuery(sql);

			query.setParameter("email", email);
			query.setParameter("senha", senha);

			s = (Aluno) query.getSingleResult();

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
	
	public boolean cadastrar(Aluno a) {
		
		Session session = null;
		try {

			session = HibernateUtil.abrirSession();

			session.save(a);

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
	
	public Aluno findUser(Aluno user) {
		// Método para Verificar se ja existe um usuário com tal nome

		Session session = null;
		Aluno a = null;
		try {

			session = HibernateUtil.abrirSession();

			String sql = "FROM alunos WHERE email = :email AND accStatus = 0 OR accStatus = 2";
			Query query = session.createQuery(sql);

			query.setParameter("email", user.getEmail());

			a = (Aluno) query.getSingleResult();

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
			errorMsg = "Aluno inválido";
			return null;
		}
		
		if(a == null) {
			errorMsg = "Erro ao Localizar Aluno";
			return null;
		}

		return a;
	}
	
	public List<Aluno> searchAlunos(String arg) {
		// User contem 'arg' -- usar SELECT * FROM users WHERE nome LIKE '%arg%'
		Session session = null;
		List<Aluno> list = null;

		try {
			
			
			
			session = HibernateUtil.abrirSession();
	        
	        String sql = "FROM alunos  WHERE nome LIKE '%"+arg+"%'";
	        
	        list = session.createQuery(sql,Aluno.class).getResultList();
	        
	        session.getTransaction().commit();
	        
	        if(session != null)
				session.close();
	        
	        if(list==null ||list.isEmpty()) {
	        	errorMsg = "Não Foi encontrado nenhum Aluno similar a '"+arg+"', verifique se o nome foi digitado corretamente";
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
	
	public List<Pedido> pegarPedidos(Aluno a) {
		Session session = null;
		List<Pedido> list = null;

		try {
			
			
			
			session = HibernateUtil.abrirSession();
	        
	        String sql = "FROM Pedido p  WHERE aluno_id = :id";
	        Query query = session.createQuery(sql);
	        
	        query.setParameter("id", a.getId());
	        
	        list = (List<Pedido>) query.getResultList();
	        
	        session.getTransaction().commit();
	        
	        if(session != null)
				session.close();
	        
	        if(list==null ||list.isEmpty()) {
	        	errorMsg = "Não foram encontrados pedidos realizados nessa conta";
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
	
	public boolean update(Aluno a) {
		Session session = null;
		try {

			session = HibernateUtil.abrirSession();

			session.update(a);

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
	
	public boolean delAluno(Aluno a) {
		Session session = null;
		try {
			
			session = HibernateUtil.abrirSession();
			
			String sql = "UPDATE alunos SET accStatus = 1 WHERE id = :id";
			
			Query query = session.createQuery(sql);

			query.setParameter("id",a.getId());
			
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
			errorMsg = "Aluno inválido";
			return false;
		}
		
		return true;
		
	}
	
	public boolean desativarAluno(Aluno a) {
		Session session = null;
		try {
			
			session = HibernateUtil.abrirSession();
			
			String sql = "UPDATE alunos SET accStatus = 2 WHERE id = :id";
			
			Query query = session.createQuery(sql);

			query.setParameter("id",a.getId());
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
			errorMsg = "Aluno inválido";
			return false;
		}
		
		return true;
		
	}


}
