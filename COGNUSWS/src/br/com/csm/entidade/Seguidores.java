package br.com.csm.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class Seguidores implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne()
	@JoinColumn(name="seguindo_user_id", referencedColumnName = "user_id")
	private User usuario;
	
	
	@ManyToOne()
	@JoinColumn(name="seguidor_user_id", referencedColumnName = "user_id")
	private User usuarios;


	public User getUsuario() {
		return usuario;
	}


	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}


	public User getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(User usuarios) {
		this.usuarios = usuarios;
	}
	

}
