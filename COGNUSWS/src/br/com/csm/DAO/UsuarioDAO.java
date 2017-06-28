package br.com.csm.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	
	public User consultar(Long user_id){
		return entityManager.getReference(User.class, user_id);
	}
	

	public List<User> listar(){
		
		String sql = "Select a from User a order by a.user_name";
		Query query = entityManager.createQuery(sql);
		
		return query.getResultList();
	}
	
	public boolean autenticarUsuario(String user_email, String user_senha){
		
		String sql = "Select" + user_email + "," + user_senha + " from User";
		Query query = entityManager.createQuery(sql);
		
		if(query == null)
			return false;
		else
			return true;
		
	}
	
}