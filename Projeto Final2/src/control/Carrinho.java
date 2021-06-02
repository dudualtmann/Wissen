package control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import model.MCarrinho;

@Entity
@Table(name = "carrinhos")
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@DynamicInsert(value = true)
public class Carrinho {
	
	@Transient
	public String errorMsg;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "carrinho_curso", joinColumns = { @JoinColumn(name = "id_carrinho") }, inverseJoinColumns = {
			@JoinColumn(name = "id_curso_carrinho") }, foreignKey = @ForeignKey(name = "FK_CARRINHO_CURSO"))
	private List<Curso> listaCursosCarrinho;
	
	public Carrinho() {
		
	}
	
	
	public boolean criarCarrinho() {
		MCarrinho mc = new MCarrinho();
		this.listaCursosCarrinho = new ArrayList<Curso>();
		if (!mc.cadastrar(this)) {
			errorMsg = mc.errorMsg;
			return false;
		}
		return true;
	}
	
public boolean find(String idAluno) {
		
		if(idAluno != null && !idAluno.trim().isEmpty()) {
			idAluno = idAluno.trim();
			this.id = Integer.parseInt(idAluno);
		}
		
		MCarrinho mc = new MCarrinho();
		Carrinho c = mc.find(this);
		
		if(c == null) {
			errorMsg = mc.errorMsg;
			return false;
		}
		
		this.id = c.id;
		this.listaCursosCarrinho = c.listaCursosCarrinho;
		
		
		return true;
	}
	
	public boolean addProduto(Curso c) {
		
		this.listaCursosCarrinho.add(c);
		
		MCarrinho mc = new MCarrinho();
		if(!mc.update(this)) {
			errorMsg = mc.errorMsg;
			return false;
		}
		
		return true;
	}
	
	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Curso> getListaCursosCarrinho() {
		return listaCursosCarrinho;
	}

	public void setListaCursosCarrinho(List<Curso> listaCursosCarrinho) {
		this.listaCursosCarrinho = listaCursosCarrinho;
	}
	
	

}
