package teste.supero.resources;

import teste.supero.dao.LivroDao;
import teste.supero.models.Livro;
import teste.supero.util.RegistroPaginado;
import teste.supero.util.Filtros;
import teste.supero.util.ParametroPaginacao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/livros")
public class LivroResource
{

   private static List<Livro> products = new ArrayList<Livro>(Arrays.asList(new Livro(
         "jaxrs-project"), new Livro("spring-project")));

   @Path("/")
   @GET
   @Produces(value = { MediaType.APPLICATION_JSON })
   public RegistroPaginado<Livro> getLivros(@BeanParam Filtros filtros, @BeanParam ParametroPaginacao parametroPaginacao)
   {
      LivroDao livroDao = new LivroDao();
      return livroDao.buscarLivro(filtros, parametroPaginacao);
   }
}
