package br.com.csm.resources;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.csm.DAO.JPAUtil;
import br.com.csm.DAO.PerguntaDAO;
import br.com.csm.DAO.RespostaDAO;
import br.com.csm.DAO.TopicoDAO;
import br.com.csm.entidade.Pergunta;
import br.com.csm.entidade.Resposta;
import br.com.csm.entidade.Topico;

@Path("/topicos")
public class TopicoResources {

	@GET
	@Path("/listarTopicos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Topico> listarTopicos(){
		
		List<Topico> list = new ArrayList<Topico>();
		EntityManager em = JPAUtil.getEntityManager();
		TopicoDAO dao = new TopicoDAO(em);	
		
		list= dao.listar();
		
		return list;	
	}
	
	@POST
	@Path("/cadastrarTopico")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Topico cadastrarPergunta(Topico topico){
		//System.out.println("GABROIIIIIIIIIIIIIIIIIIIIIIIII");
		//System.out.println("RETORNOS - >>>" + pergunta.getDescricao()+ " " + pergunta.getTexto_perg() +" " +  pergunta.getUser_id());
		
		EntityManager em = JPAUtil.getEntityManager();
		TopicoDAO dao = new TopicoDAO(em);
		em.getTransaction().begin();
		dao.cadastrar(topico);	
		em.getTransaction().commit();
		
		return topico;
	}
	
	@POST
	@Path("/listarTopicoPergunta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Topico> buscarTopicoPergunta(String id){
		System.out.println("ENTRANDO NO LISTAR TOPICO PERGUNTA\n");
		System.out.println("ID >> " + id);
		List<Topico> list = new ArrayList<Topico>();
		EntityManager em = JPAUtil.getEntityManager();
		TopicoDAO dao = new TopicoDAO(em);
		
		list=dao.listarTopicoPergunta(id);
		
		if(list.size() == 1) {
			Topico r = list.get(0);
			list.add(r);
		}			
		
		System.out.println("RETORNANDO TOPICO PERGUNTA >> " + list);
		return list;
	}
	
	@POST
	@Path("/listarTopicosUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Topico> listarTopicosUsuario(String id){
		System.out.println("ENTRANDO NO LISTAR PERGUNTAS TOPICO\n");
		List<Topico> list = new ArrayList<Topico>();
		EntityManager em = JPAUtil.getEntityManager();
		TopicoDAO dao = new TopicoDAO(em);
		
		list=dao.listarTopicosUsuario(id);
		
		if(list.size() == 1) {
			Topico r = list.get(0);
			list.add(r);
		}			
		
		System.out.println("RETORNANDO PERGUNTAS TOPICO >> " + list);
		return list;
	}
	
}
