package br.com.csm.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

import br.com.csm.entidade.Topico;
import br.com.csm.entidade.User;

public class UsuarioDAO {
	
	private EntityManager entityManager;
	
	public UsuarioDAO(EntityManager entityManager){
		this.entityManager= entityManager;
	}
	
	public void cadastrar(User usuario){		
		entityManager.persist(usuario);
	}
	
	public void alterar(User usuario){
		entityManager.merge(usuario);
	}
	
	public void excluir(User usuario){
		entityManager.remove(entityManager.merge(usuario));
	}
	
//	public User consultar(Long user_id){
//		return entityManager.getReference(User.class, user_id);
//	}
	

	public List<User> listar(){
		
		String sql = "Select a from User a order by a.user_name";
		Query query = entityManager.createQuery(sql);
		
		return query.getResultList();
	}
	
	public User getUser(long id) {

		String sql = "Select a from User a where a.user_id="+id;
		//String sql = "Select * from User where user_id="+id;
		Query query = entityManager.createQuery(sql);

		return (User) query.getSingleResult();
	}
	
	public User getUserEmail(String email) {

		String nome = email.substring(1,email.length()-1);
		System.out.println("NOOOME>>>" + nome);
		String sql = "Select a from User a where a.user_email='"+nome+"'";
		Query query = entityManager.createQuery(sql);

		return (User) query.getSingleResult();
	}
	
	public User autenticarUsuario(String email, String senha){
		
		
		System.out.println("EMAIL >> " + email + "\nSENHA >> " + senha);
		String sql = "Select a from User a where a.user_email='" +email+"' and a.user_senha='" +senha+"'";
		Query query = entityManager.createQuery(sql);
		
		return (User) query.getSingleResult();
	
	}
	
	
	
	
}