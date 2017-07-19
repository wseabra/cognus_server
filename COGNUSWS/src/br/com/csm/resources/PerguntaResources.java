package br.com.csm.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		String[] topicos = null;
		System.out.println("GABROIIIIIIIIIIIIIIIIIIIIIIIII");
		System.out.println("RETORNOS - >>>" + pergunta.getDescricao()+ " " + pergunta.getTexto_perg() +" " +  pergunta.getUser_id());
		
		topicos = getTopicos(pergunta.getDescricao());
		
		EntityManager em = JPAUtil.getEntityManager();
		PerguntaDAO dao = new PerguntaDAO(em);
		em.getTransaction().begin();
		dao.cadastrar(pergunta);	
		em.getTransaction().commit();
		
		return pergunta;
	}
	
	private String[] getTopicos(String s) {

        try {

			String[] cmd = {"python2.7","/home/damhur/Dropbox/Cognus/nlpnet/pos-pt/extracao.py",s};
            Process p = Runtime.getRuntime().exec(cmd);

            BufferedReader stdInput = new BufferedReader(new
                 InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                 InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
        		String saida = stdInput.readLine();

			System.out.println("lista de topicos");
			String[] topicos = saida.split(";");

			for (String i : topicos) {

					System.out.println(i);

			}

            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
            
            return topicos;            

        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
        }	
        return null;
	}
	

}
