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
import br.com.csm.DAO.UsuarioDAO;
import br.com.csm.entidade.User;

@Path("/usuarios")
public class UsuarioResources {
	
	
	@GET
	@Path("/listarUsuarios")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<User> listUsuarios(){
		List<User> list = new ArrayList<User>();
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);	
		list=dao.listar();
		
		return list;
		
	}
	
	@POST
	@Path("/consultarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User buscarUsuario(long id){
		User usuario = new User();
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);
		usuario = dao.consultar(id);
		
		return usuario;
	}
	
	@POST
	@Path("/cadastrarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User cadastrarUsuario(User usuario){
		//User usu = new User();
		System.out.println(usuario.getUser_email());
		
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);
		em.getTransaction().begin();
		dao.cadastrar(usuario);	
		em.getTransaction().commit();
		
		System.out.println("TESTE FRASE");
		return usuario;
	}
	
	@POST
	@Path("/autenticarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User autenticarUsuario(String user_email, String user_senha){
		User usuario = new User();
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);
		if(dao.autenticarUsuario(user_email, user_senha))
			return usuario;
		else
			return null;
	}
	

}