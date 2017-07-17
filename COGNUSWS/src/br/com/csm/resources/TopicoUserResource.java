//package br.com.csm.resources;
//
//import javax.persistence.EntityManager;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//import br.com.csm.DAO.JPAUtil;
//import br.com.csm.DAO.TopicoUserDAO;
//import br.com.csm.entidade.TopicoUser;
//
//public class TopicoUserResource {
//	
//	@POST
//	@Path("/cadastrarTopicoUser")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public TopicoUser cadastrarTopicoUser(TopicoUser topicouser){
//		//System.out.println("GABROIIIIIIIIIIIIIIIIIIIIIIIII");
//		//System.out.println("RETORNOS - >>>" + pergunta.getDescricao()+ " " + pergunta.getTexto_perg() +" " +  pergunta.getUser_id());
//		
//		EntityManager em = JPAUtil.getEntityManager();
//		TopicoUserDAO dao = new TopicoUserDAO(em);
//		em.getTransaction().begin();
//		dao.cadastrar(topicouser);	
//		em.getTransaction().commit();
//		
//		return topicouser;
//	}
//
//}
