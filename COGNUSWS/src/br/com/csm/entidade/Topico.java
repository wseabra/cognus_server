package br.com.csm.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Topico implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long topico_id;
	
	@Column
	private String descricao_topico;
	
	@Column
	private long num_seguidores;
	
	@ManyToMany
	@JoinTable(name = "TopicoPergunta", joinColumns=
	{@JoinColumn(name="topico_id")},
	inverseJoinColumns={@JoinColumn(name="perg_id")})
	private List<Pergunta> listPergunta;
	
	public long getTopico_id() {
		return topico_id;
	}
	public void setTopico_id(long topico_id) {
		this.topico_id = topico_id;
	}
	
	public String getDescricao_topico() {
		return descricao_topico;
	}
	public void setDescricao_topico(String descricao_topico) {
		this.descricao_topico = descricao_topico;
	}
	
	public long getNum_seguidores() {
		return num_seguidores;
	}
	public void setNum_seguidores(long num_seguidores) {
		this.num_seguidores = num_seguidores;
	}
	
	public List<Pergunta> getListPergunta() {
		return listPergunta;
	}
	public void setListPergunta(List<Pergunta> listPergunta) {
		this.listPergunta = listPergunta;
	}

}
