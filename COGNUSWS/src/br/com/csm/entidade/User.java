package br.com.csm.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue
	private long user_id;
	@Column
	private String user_name;
	@Column
	private String user_email;
	@Column
	private String user_senha;
	@Column
	private long user_numseguidores;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "TopicoUser", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="topico_id"))
	private List<Topico> listTopicos;
	
	
	public long getUser_id() {
		return user_id;
	}
	
	public List<Topico> getListTopicos() {
		return listTopicos;
	}

	public void setListTopicos(List<Topico> listTopicos) {
		this.listTopicos = listTopicos;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	
	@Column(name = "user_name", unique = true, nullable = false)
	public String getUser_name() {
		return user_name;
	}
	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	@Column(name = "user_email", unique = true, nullable = false)
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	
	public String getUser_senha() {
		return user_senha;
	}
	public void setUser_senha(String user_senha) {
		this.user_senha = user_senha;
	}
	
	
	public long getUser_numseguidores() {
		return user_numseguidores;
	}
	public void setUser_numseguidores(long user_numseguidores) {
		this.user_numseguidores = user_numseguidores;
	}

	
	
	
	//gets and setters....
	

	
	
	
	

}