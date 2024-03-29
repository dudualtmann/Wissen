package control;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.ForeignKey;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import model.MAluno;

@Entity(name = "alunos")
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@DynamicInsert(value = true)
public class Aluno extends Pessoa {

	@Transient
	public String errorMsg;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno", fetch = FetchType.LAZY)
	private List<Pedido> listaPedidos = new ArrayList<Pedido>();
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_carrinho", nullable = true, foreignKey = @ForeignKey(name =
    		"fk_Aluno_Carrinho"))
    private Carrinho carrinho;
	

	public Aluno() {

	}

	public Aluno(String nome, String senha, String email) {
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		carrinho = new Carrinho();
	}
	
	public Aluno(String nome, String senha, String email, String cpf, Date dataNascimento, String nacionalidade, String sexo, File fotoPerfil) {
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
		this.sexo = sexo;
		this.fotoPerfil = fotoPerfil;
	}

	public boolean cadastrar() {

		MAluno ma = new MAluno();

		if (!ma.cadastrar(this)) {
			errorMsg = ma.errorMsg;
			return false;
		}

		return true;
	}

	public boolean login(String email, String senha) {
		MAluno ma = new MAluno();
		if(email == null || email.isEmpty() || !email.contains("@")) {
			errorMsg = "Email Inv�lido.";
			return false;
		} else if(senha == null || senha.isEmpty() || senha.length() > 25) {
			errorMsg = "Senha Inv�lida.";
			return false;
		}
				
		Aluno a = ma.login(email, senha);
		
		
		if(a == null) {
			errorMsg = ma.errorMsg;
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
		this.carrinho = a.getCarrinho();
		
		
		
		return true;
		
	}

	public boolean findAluno(String email) {
		
		if (email == null || email.isEmpty()) {
			errorMsg = "Email Inv�lido.";
			return false;
		}
		
		MAluno ma = new MAluno();
		this.email = email;
		Aluno a = ma.findUser(this);
		if (a == null) {
			errorMsg = ma.errorMsg;
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
		this.carrinho = a.getCarrinho();

		return true;

	}
	
	public List<Curso> meusCursos(){
		MAluno ma = new MAluno();
		listaPedidos = ma.pegarPedidos(this);
		
		if(listaPedidos == null) {
			errorMsg = "N�o foram encontrados cursos associados a essa conta";
			System.out.println("Deu null");
			return null;
		}
		
		List<Curso> meusCursos = new ArrayList<Curso>();
		for(int i = 0; i < listaPedidos.size(); i++) {
			for(int j = 0; j<listaPedidos.get(i).getListaCursos().size(); j++) {
				meusCursos.add(listaPedidos.get(i).getListaCursos().get(j));
			}
			
		}
		
		System.out.println("N�o deu null: "+meusCursos.size());
		
		return meusCursos;
		
	}

	

	public List<Aluno> searchAlunos(String arg) {
		// User contem 'arg' -- usar SELECT * FROM users WHERE nome LIKE '%arg%'

		MAluno ma = new MAluno();
		List<Aluno> searchAlunos = ma.searchAlunos(arg);
		if (searchAlunos == null) {
			errorMsg = ma.errorMsg;
			return null;
		}
		return searchAlunos;

	}

	public boolean update() {

		MAluno ma = new MAluno();

		if (!ma.update(this)) {
			errorMsg = ma.errorMsg;
			return false;
		}

		return true;

	}

	public boolean delAluno() {
		MAluno ma = new MAluno();

		if (!ma.delAluno(this)) {
			errorMsg = ma.errorMsg;
			return false;
		}

		return true;
	}

	public boolean desativarAluno() {
		MAluno ma = new MAluno();

		if (!ma.desativarAluno(this)) {
			errorMsg = ma.errorMsg;
			return false;
		}

		return true;
	}

	/* --------- Formata��o de Data se Necess�rio ---------------------- */
//	SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd"); 
//	Date data = null;
//	try {
//		dataNascimento = dataNascimento.replace("-", "/");
//		data = formato.parse(dataNascimento);
//		System.out.println(dataNascimento);
//		System.out.println(data);
//	} catch (ParseException e) {
//		errorMsg = e.toString();
//		e.printStackTrace(); // Deixando apenas para corre��o de poss�vel bug
//	}
	
	// Getters and Setters
	
	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
	
	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

}
