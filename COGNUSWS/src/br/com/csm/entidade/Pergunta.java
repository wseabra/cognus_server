package br.com.csm.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name="Pergunta")
public class Pergunta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long perg_id;
	
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="user_id")
	private User user_id;
	
	@Column
	private String texto_perg;
	
	@Column
	private String descricao;

	public long getPerg_id() {
		return perg_id;
	}
	public void setPerg_id(long perg_id) {
		this.perg_id = perg_id;
	}
	
	public String getTexto_perg() {
		return texto_perg;
	}
	public void setTexto_perg(String texto_perg) {
		this.texto_perg = texto_perg;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	
	

}
