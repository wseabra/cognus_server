package br.com.csm.DAO;

import javax.persistence.EntityManager;

import br.com.csm.entidade.Resposta;
import br.com.csm.entidade.Seguidores;

public class SeguidoresDAO {
	
	private EntityManager entityManager;
	
	public SeguidoresDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public void cadastrar(Seguidores s){
		entityManager.persist(s);
	}
	
	public void alterar(Seguidores s){
		entityManager.merge(s);
	}
	
	public void excluir(Seguidores s){
		entityManager.remove(entityManager.merge(s));
	}
	
	public Seguidores consultar(Long id){
		return entityManager.getReference(Seguidores.class, id);
	}

}
