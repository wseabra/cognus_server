package br.com.csm.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.csm.entidade.Topico;

public class TopicoDAO {
	
	private EntityManager entityManager;
	
	public TopicoDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public void cadastrar(Topico topico){
		entityManager.persist(topico);
	}
	
	public void alterar(Topico topico){
		entityManager.merge(topico);
	}
	
	public void excluir(Topico topico){
		entityManager.remove(entityManager.merge(topico));
	}
	
	public Topico consultar(Long topico_id){
		return entityManager.getReference(Topico.class, topico_id);
	}
	
	public List<Topico> listar(){
		
		String sql = "Select a from Topico a order by a.topico_id";
		Query query = entityManager.createQuery(sql);
		
		return query.getResultList();
	}
}
