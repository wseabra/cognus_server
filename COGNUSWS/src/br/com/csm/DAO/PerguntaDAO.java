package br.com.csm.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.csm.entidade.Pergunta;
import br.com.csm.entidade.Topico;
import br.com.csm.entidade.User;

public class PerguntaDAO {
	
	private EntityManager entityManager;
	
	public PerguntaDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public void cadastrar(Pergunta pergunta){
		entityManager.persist(pergunta);
	}
	
	public void alterar(Pergunta pergunta){
		entityManager.merge(pergunta);
	}
	
	public void excluir(Pergunta pergunta){
		entityManager.remove(entityManager.merge(pergunta));
	}
	
	public Pergunta consultar(Long pergunta_id){
		return entityManager.getReference(Pergunta.class, pergunta_id);
	}
	
	public List<Pergunta> listar(){
		
		String sql = "Select a from Pergunta a order by a.perg_id";
		Query query = entityManager.createQuery(sql);
		
		return query.getResultList();
	}
	
}	
