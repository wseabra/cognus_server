//package br.com.csm.entidade;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.xml.bind.annotation.XmlRootElement;
//
//@Entity
//@XmlRootElement
//public class TopicoUser implements Serializable{
//	
//	private static final long serialVersionUID = 1L;
//	
//	@ManyToOne()
//	@JoinColumn(name="user_id", referencedColumnName = "user_id")
//	private long user_id;
//	
//	@ManyToOne()
//	@JoinColumn(name="topico_id", referencedColumnName = "topico_id")
//	private long topico_id;
//	
//	
//	public long getId_user() {
//		return user_id;
//	}
//	public void setId_user(long user_id) {
//		this.user_id = user_id;
//	}
//	public long getTopico_id() {
//		return topico_id;
//	}
//	public void setTopico_id(long topico_id) {
//		this.topico_id = topico_id;
//	}
//	
//	
//
//}
