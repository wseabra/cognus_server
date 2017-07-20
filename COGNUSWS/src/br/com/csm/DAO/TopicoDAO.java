package br.com.csm.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.csm.entidade.Pergunta;
import br.com.csm.entidade.Resposta;
import br.com.csm.entidade.Topico;

public class TopicoDAO {

	private EntityManager entityManager;

	public TopicoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void cadastrar(Topico topico) {
		entityManager.persist(topico);
	}

	public void alterar(Topico topico) {
		entityManager.merge(topico);
	}

	public void excluir(Topico topico) {
		entityManager.remove(entityManager.merge(topico));
	}

	public Topico consultar(Long topico_id) {
		return entityManager.getReference(Topico.class, topico_id);
	}

	public List<Topico> listar() {

		String sql = "Select a from Topico a order by a.topico_id";
		Query query = entityManager.createQuery(sql);

		return query.getResultList();
	}

	public Topico exitstTopics(String text) {
		try {
			String sql = "Select a from Topico a where a.descricao_topico= '"+text+"'";
			Query query = entityManager.createQuery(sql);

			return (Topico) query.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}		
	}
	
	public List<Topico> listarTopicoPergunta(String id){
		
		String sql = "Select t from Topico t inner join t.listPergunta p where p.perg_id="+id;
		Query query = entityManager.createQuery(sql);
		
		return query.getResultList();
	}
	
	public List<Pergunta> listarPerguntasTopico(String id){
		
		String sql = "Select t from Topico t inner join t.listPergunta p where t.topico_id="+id;
		Query query = entityManager.createQuery(sql);
		
		//System.out.println("QUERY >>>" + query);
		
		return query.getResultList();
	}
	
	public List<Topico> listarTopicosUsuario(String id){
		
		String sql = "Select t from Topico t, User u inner join u.listTopicos a where t.topico_id=a.topico_id and u.user_id="+id;
		//String sql = "Select p from Pergunta p, Topico t inner join t.listPergunta a where p.perg_id=a.perg_id and t.topico_id="+id;
		Query query = entityManager.createQuery(sql);
		
		//System.out.println("QUERY >>>" + query);
		
		return query.getResultList();
	}
	
}
