package br.com.csm.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Pergunta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long perg_id;
	@ManyToOne()
	@JoinColumn(name="user_id", referencedColumnName = "user_id")
	private User usuario;
	private String texto_perg;
	
	private String descricao;
	
	@Id
	@GeneratedValue
	@Column(name = "perg_id", unique = true, nullable = false)
	public long getPerg_id() {
		return perg_id;
	}
	public void setPerg_id(long perg_id) {
		this.perg_id = perg_id;
	}
	
	
	@Column(name = "texto_perg", unique = true, nullable = false)
	public String getTexto_perg() {
		return texto_perg;
	}
	public void setTexto_perg(String texto_perg) {
		this.texto_perg = texto_perg;
	}
	
	@Column(name = "descricao", unique = true, nullable = false)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public User getUsuario() {
		return usuario;
	}
	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
	

}