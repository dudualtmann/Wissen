package control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import model.MPedido;


@Entity
@Table(name = "pedidos")
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@DynamicInsert(value = true)
public class Pedido {
	
	@Transient
	public String errorMsg;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private double preco;
	
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
	
	@ManyToMany(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "pedidos_cursos", joinColumns = { @JoinColumn(name = "id_pedido") }, inverseJoinColumns = {
			@JoinColumn(name = "id_curso") }, foreignKey = @ForeignKey(name = "FK_PEDIDO_CURSO"))
	private List<Curso> listaCursosPedidos = new ArrayList<Curso>();
	
	@Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date dataPedido;
	
	@Column(nullable = false)
	private String metodoPagamento;
	
	@Column(nullable = false, columnDefinition = "VARCHAR(100) DEFAULT 'Confirmado'")
	private String status;
	
	public Pedido() {
		
	}
	
	public Pedido(String price, String metodoPagamento, Aluno aluno, List<Curso> listaCursos) {
		
		if (price != null && !price.trim().equals(""))
			this.preco = Double.parseDouble(price);
		
		this.metodoPagamento = metodoPagamento;
		this.aluno = aluno;
		this.listaCursosPedidos = listaCursos;
		this.dataPedido = new Date();
		this.status = "Confirmado";
		
	}
	
	public boolean cadastrar() {

		MPedido mp = new MPedido();
		if (!mp.cadastrar(this)) {
			errorMsg = mp.errorMsg;
			return false;
		}
		return true;
	}
	
	

	
	
	//Getters and Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Curso> getListaCursos() {
		return listaCursosPedidos;
	}

	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursosPedidos = listaCursos;
	}
	
	
	
	
	
	
	
	
	
	

}
