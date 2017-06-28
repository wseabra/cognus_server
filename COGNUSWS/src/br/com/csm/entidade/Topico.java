package br.com.csm.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Topico implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long topico_id;
	private String descricao_topico;
	private long num_seguidores;
	
	@Id
	@GeneratedValue
	@Column(name = "topico_id", unique = true, nullable = false)
	public long getTopico_id() {
		return topico_id;
	}
	public void setTopico_id(long topico_id) {
		this.topico_id = topico_id;
	}
	
	@Column(name = "descricao_topico", unique = true, nullable = false)
	public String getDescricao_topico() {
		return descricao_topico;
	}
	public void setDescricao_topico(String descricao_topico) {
		this.descricao_topico = descricao_topico;
	}
	
	@Column(name = "num_seguidores", unique = true, nullable = false)
	public long getNum_seguidores() {
		return num_seguidores;
	}
	public void setNum_seguidores(long num_seguidores) {
		this.num_seguidores = num_seguidores;
	}
	
	

}
