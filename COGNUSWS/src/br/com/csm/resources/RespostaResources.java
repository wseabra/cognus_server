package br.com.csm.resources;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.csm.DAO.JPAUtil;
import br.com.csm.DAO.PerguntaDAO;
import br.com.csm.DAO.RespostaDAO;
import br.com.csm.entidade.Pergunta;
import br.com.csm.entidade.Resposta;

@Path("/respostas")
public class RespostaResources {

	@GET
	@Path("/listarRespostas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Resposta> listPerguntas(){
		
		List<Resposta> list = new ArrayList<Resposta>();
		EntityManager em = JPAUtil.getEntityManager();
		RespostaDAO dao = new RespostaDAO(em);	
		
		list=dao.listarResposta();
		
		System.out.println("TESTEEE");
		
		return list;	
	}
}
