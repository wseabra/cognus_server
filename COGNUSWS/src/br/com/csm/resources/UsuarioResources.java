package br.com.csm.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import br.com.csm.DAO.JPAUtil;
import br.com.csm.DAO.TopicoDAO;
import br.com.csm.DAO.UsuarioDAO;
import br.com.csm.entidade.Topico;
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
		
		System.out.println("TESTEEE");
		
		return list;	
	}
	
	@POST
	@Path("/consultarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User buscarUsuario(String id){
		User usuario = new User();
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);
		
		try{
			System.out.println(id);
			usuario = dao.getUser(Long.parseLong(id));
		}catch (Exception e) {
			usuario = null;
		}	
		return usuario;
	}
	
	@POST
	@Path("/consultarUsuarioEmail")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User buscarUsuarioEmail(String email){
		User usuario = new User();
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);
		
		try{
			usuario = dao.getUserEmail(email);
		}catch (Exception e) {
			usuario = null;
		}
		return usuario;
	}
	
	
	@POST
	@Path("/cadastrarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User cadastrarUsuario(User usuario){
		System.out.println("RECEBENDO EMAIL\n>>>> " + usuario.getUser_email() + "\nRECEBENDO LIST TOPICOS\n  " + usuario.getListTopicos());
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);
		em.getTransaction().begin();
		dao.cadastrar(usuario);
		em.getTransaction().commit();
		
		System.out.println("RETORNADN CADASTRO >>>>\n" + usuario);
		
		System.out.println(usuario.getListTopicos());
		
		return usuario;
	}
	
	@POST
	@Path("/autenticarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User autenticarUsuario(User usuario){
		User usuario2 = new User();
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);		
		try{
			usuario2 = dao.autenticarUsuario(usuario.getUser_email(), usuario.getUser_senha());
 
		}catch (Exception e) {
			System.out.println("ENTROU NO EXCEPTION!! -----------------------------");
			usuario2 = null;
		}
		
		System.out.println("RETORNANDO >>>>> " + usuario2);
		System.out.println("LIST TOPICOS>>>> " + usuario2.getListTopicos());
		return usuario2;
	}
}