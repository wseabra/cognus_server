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
import br.com.csm.DAO.UsuarioDAO;
import br.com.csm.entidade.Pergunta;
import br.com.csm.entidade.User;

@Path("/perguntas")
public class PerguntaResources {
	
	
	@GET
	@Path("/listarPerguntas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Pergunta> listPerguntas(){
		
		List<Pergunta> list = new ArrayList<Pergunta>();
		EntityManager em = JPAUtil.getEntityManager();
		PerguntaDAO dao = new PerguntaDAO(em);	
		
		list=dao.listar();
		
		System.out.println("TESTEEE");
		
		return list;	
	}
	
	@POST
	@Path("/cadastrarPergunta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Pergunta cadastrarPergunta(Pergunta pergunta){
		System.out.println("GABROIIIIIIIIIIIIIIIIIIIIIIIII");
		System.out.println("RETORNOS - >>>" + pergunta.getDescricao()+ " " + pergunta.getTexto_perg() +" " +  pergunta.getUser_id());
		
		EntityManager em = JPAUtil.getEntityManager();
		PerguntaDAO dao = new PerguntaDAO(em);
		em.getTransaction().begin();
		dao.cadastrar(pergunta);	
		em.getTransaction().commit();
		
		return pergunta;
	}
	
	

}
