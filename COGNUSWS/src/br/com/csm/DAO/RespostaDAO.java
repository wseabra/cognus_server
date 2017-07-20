package br.com.csm.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.csm.entidade.Pergunta;
import br.com.csm.entidade.Resposta;

public class RespostaDAO {
	
	private EntityManager entityManager;
	
	public RespostaDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public void cadastrar(Resposta resposta){
		entityManager.persist(resposta);
	}
	
	public void alterar(Resposta resposta){
		entityManager.merge(resposta);
	}
	
	public void excluir(Resposta resposta){
		entityManager.remove(entityManager.merge(resposta));
	}
	
	public Resposta consultar(Long resposta_id){
		return entityManager.getReference(Resposta.class, resposta_id);
	}
	
	public List<Resposta> listarResposta(){
		
		String sql = "Select a from Resposta a order by a.resp_id";
		Query query = entityManager.createQuery(sql);
		
		return query.getResultList();
	}
	
	public List<Resposta> listarRespostaPergunta(String id){
		
		String sql = "Select a from Resposta a where a.perg_id="+id;
		Query query = entityManager.createQuery(sql);
		
		return query.getResultList();
	}

}
