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
		List<User> lista2 = new ArrayList<User>();
		
		for (User user : list) {
			User novoUsuario = duplicarTop(user);
			lista2.add(novoUsuario);
		}
		
		
		return lista2;	
	}
	
	public User duplicarTop(User usuario) {
		if(usuario.getListTopicos().size() == 1)
		{
			System.out.println("só 1");
			List<Topico> lista = usuario.getListTopicos();
			Topico topico = lista.get(0);
			lista.add(topico);
			usuario.setListTopicos(lista);
		}
		return usuario;
	}
	
	@POST
	@Path("/consultarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User buscarUsuario(String id){
		System.out.println("ENTRANDO NO BUSCAR USUARIO!!!\n");
		User usuario = new User();
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);
		
		try{
			System.out.println("ID >> " + id);
			usuario = dao.getUser(Long.parseLong(id));
			if(usuario.getListTopicos() != null && usuario.getListTopicos().size() == 1)
			{
				System.out.println("\nsó 1 tópico");
				List<Topico> lista = usuario.getListTopicos();
				Topico topico = lista.get(0);
				lista.add(topico);
				usuario.setListTopicos(lista);
			}
		}catch (Exception e) {
			System.out.println("\nENTROU NO EXCEPTION (BUSCAR USUARIO)");
			usuario = null;
		}
		
		System.out.println("RETORNANDO BUSCAR USUARIO ->>>>" + usuario);
		return usuario;
	}
	
	@POST
	@Path("/consultarUsuarioEmail")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User buscarUsuarioEmail(String email){
		System.out.println("Recebendo >>>\n" + email);
		User usuario = new User();
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);
		
		try{
			usuario = dao.getUserEmail(email);
			if(usuario.getListTopicos().size() == 1)
			{
				System.out.println("só 1");
				List<Topico> lista = usuario.getListTopicos();
				Topico topico = lista.get(0);
				lista.add(topico);
				usuario.setListTopicos(lista);
			}
		}catch (Exception e) {
			usuario = null;
		}
		System.out.println("Enviando >>>\n" + usuario);
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
		
		if(usuario.getListTopicos().size() == 1)
		{
			System.out.println("só 1");
			List<Topico> lista = usuario.getListTopicos();
			Topico topico = lista.get(0);
			lista.add(topico);
			usuario.setListTopicos(lista);
		}
		
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
			if(usuario2.getListTopicos().size() == 1)
			{
				System.out.println("só 1");
				List<Topico> lista = usuario2.getListTopicos();
				Topico topico = lista.get(0);
				lista.add(topico);
				usuario2.setListTopicos(lista);
			}
 
		}catch (Exception e) {
			System.out.println("ENTROU NO EXCEPTION!! -----------------------------");
			usuario2 = null;
		}
		
		System.out.println("RETORNANDO >>>>> " + usuario2);
		System.out.println("LIST TOPICOS>>>> " + usuario2.getListTopicos());
		return usuario2;
	}
	
	@POST
	@Path("/listarTopicoUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Topico> listarTopicoUsuario(String id){
		System.out.println("ENTRANDO NO LISTAR TOPICO USUARIO\n");
		System.out.println("ID >>> " + id);
		List<Topico> list = new ArrayList<Topico>();
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);
		
		list=dao.listarTopicoUsuario(id);
		
		if(list.size() == 1) {
			Topico r = list.get(0);
			list.add(r);
		}			
		
		System.out.println("RETORNANDO TOPICO USUARIO >> " + list);
		return list;
	}
}