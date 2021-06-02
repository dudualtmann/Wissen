package control;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import model.MAula;

@Entity
@Table(name = "aulas")
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@DynamicInsert(value = true)
public class Aula {

	@Transient
	public String errorMsg;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "modulo_id")
	private Modulo modulo;
	
	@Column(nullable = true)
	private File videoAula;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = true)
	private File material;
	
	public Aula() {
		
	}
	
	public Aula(Modulo modulo, File videoAula, String title, File material) {
		this.modulo = modulo;
		this.videoAula = videoAula;
		this.title = title;
		this.material = material;
	}
	
	public boolean cadastrar() {
		
		MAula ma = new MAula();
		
		if(!ma.cadastrar(this)) {
			errorMsg = ma.errorMsg;
			return false;
		}
		
		return true;
	}
	
	// Getters and Setters

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public File getVideoAula() {
		return videoAula;
	}

	public void setVideoAula(File videoAula) {
		this.videoAula = videoAula;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public File getMaterial() {
		return material;
	}

	public void setMaterial(File material) {
		this.material = material;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}
