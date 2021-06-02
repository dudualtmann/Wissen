package control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import model.MInstrutor;

@Entity(name="instrutores")
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@DynamicInsert(value = true)
public class Instrutor extends Pessoa {
	
	@Transient
	public String errorMsg;
	
	@ManyToMany(mappedBy = "listaInstrutores", fetch = FetchType.EAGER)
    List<Curso> listaCursos = new ArrayList<Curso>();
	
	public Instrutor() {
		
	}
	
	public Instrutor(String nome, String cpf, String email, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}
	
	public boolean cadastrar() {
		
		MInstrutor mi = new MInstrutor();
		
		if(!mi.cadastrar(this)) {
			errorMsg = mi.errorMsg;
			return false;
		}
		
		return true;
	}
	
	public boolean login(String email, String senha) {
		
		MInstrutor mi = new MInstrutor();
		if(email == null || email.isEmpty() || !email.contains("@")) {
			errorMsg = "Email Inválido.";
			return false;
		} else if(senha == null || senha.isEmpty() || senha.length() > 25) {
			errorMsg = "Senha Inválida.";
			return false;
		}
				
		Instrutor a = mi.login(email, senha);
		
		
		if(a == null) {
			errorMsg = mi.errorMsg;
			return false;
		}
		
		this.id = a.getId();
		this.nome = a.getNome();
		this.senha = a.getSenha();
		this.dataNascimento = a.getDataNascimento();
		this.accStatus = a.getAccStatus();
		this.cpf = a.getCpf();
		this.email = a.getEmail();
		this.fotoPerfil = a.getFotoPerfil();
		this.nacionalidade = a.getNacionalidade();
		this.sexo = a.getSexo();
		this.listaCursos = a.getListaCursos();
		
		
		
		return true;
		
	}
	
	public boolean findInstrutor(String email) {
		MInstrutor mi = new MInstrutor();
		if (email == null || email.isEmpty()) {
			errorMsg = "Email Inválido.";
			return false;
		}
		this.email = email;
		Instrutor i = mi.findUser(this);
		if (i == null) {
			errorMsg = mi.errorMsg;
			return false;
		}

		this.id = i.getId();
		this.nome = i.getNome();
		this.senha = i.getSenha();
		this.dataNascimento = i.getDataNascimento();
		this.accStatus = i.getAccStatus();
		this.cpf = i.getCpf();
		this.email = i.getEmail();
		this.fotoPerfil = i.getFotoPerfil();
		this.nacionalidade = i.getNacionalidade();
		this.sexo = i.getSexo();
		this.listaCursos = i.getListaCursos();

		return true;

	}
	
	public List<Instrutor> searchInstrutores(String arg) {
		// User contem 'arg' -- usar SELECT * FROM users WHERE nome LIKE '%arg%'

		MInstrutor mi = new MInstrutor();
		List<Instrutor> searchInstrutores = mi.searchInstrutores(arg);
		if (searchInstrutores == null) {
			errorMsg = mi.errorMsg;
			return null;
		}
		return searchInstrutores;

	}

	public boolean update() {

		MInstrutor mi = new MInstrutor();

		if (!mi.update(this)) {
			errorMsg = mi.errorMsg;
			return false;
		}

		return true;

	}

	public boolean delInstrutor() {
		MInstrutor mi = new MInstrutor();

		if (!mi.delInstrutor(this)) {
			errorMsg = mi.errorMsg;
			return false;
		}

		return true;
	}

	public boolean desativarInstrutor() {
		MInstrutor mi = new MInstrutor();

		if (!mi.desativarInstrutor(this)) {
			errorMsg = mi.errorMsg;
			return false;
		}

		return true;
	}
	
	// Getters and Setters

	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(List<Curso> cursos) {
		this.listaCursos = cursos;
	}
	
	

}
