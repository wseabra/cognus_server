package br.com.csm.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name="Resposta")
public class Resposta implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long resp_id;

	@Column
	private long perg_id;
	@Column
	private String texto_resp;
	@Column
	private long num_votos_positivos;
	@Column
	private long num_votos_negativos;
	@Column
	private long user_id;

	public long getResp_id() {
		return resp_id;
	}

	public void setResp_id(long resp_id) {
		this.resp_id = resp_id;
	}

	public long getPerg_id() {
		return perg_id;
	}

	public void setPerg_id(long perg_id) {
		this.perg_id = perg_id;
	}

	public String getTexto_resp() {
		return texto_resp;
	}

	public void setTexto_resp(String texto_resp) {
		this.texto_resp = texto_resp;
	}

	public long getNum_votos_positivos() {
		return num_votos_positivos;
	}

	public void setNum_votos_positivos(long num_votos_positivos) {
		this.num_votos_positivos = num_votos_positivos;
	}

	public long getNum_votos_negativos() {
		return num_votos_negativos;
	}

	public void setNum_votos_negativos(long num_votos_negativos) {
		this.num_votos_negativos = num_votos_negativos;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}


//
//	public List<Pergunta> getListPergunta() {
//		return listPergunta;
//	}
//
//	public void setListPergunta(List<Pergunta> listPergunta) {
//		this.listPergunta = listPergunta;
//	}

}
