package br.com.csm.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.csm.entidade.Topico;
import br.com.csm.entidade.TopicoUser;

public class TopicoUserDAO {

	private EntityManager entityManager;
	
	public TopicoUserDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public void cadastrar(TopicoUser topico){
		entityManager.persist(topico);
	}
	
	public void alterar(TopicoUser topico){
		entityManager.merge(topico);
	}
	
	public void excluir(TopicoUser topico){
		entityManager.remove(entityManager.merge(topico));
	}
	
	public Topico consultar(Long topico_id){
		return entityManager.getReference(Topico.class, topico_id);
	}
	
	public List<Topico> listar(){
		
		String sql = "Select a from TopicoUser a order by a.user_id";
		Query query = entityManager.createQuery(sql);
		
		return query.getResultList();
	}
}
