package teste.supero.util;

import teste.supero.models.Livro;

import java.util.LinkedList;
import java.util.List;

public class PaginacaoUtil {
    private  Integer quantidadePaginas = 6;
    private  Integer quantidadeAvancoPaginas = 49;
    private  RegistroPaginado registroPaginado;

    public PaginacaoUtil(RegistroPaginado registroPaginado) {
        this.registroPaginado = registroPaginado;
    }

    public  List<Pagina> criarPaginas(){
        List<Pagina> paginas = new LinkedList<>();
        criarPaginasAtalhoInicio( paginas);
        criarPaginas(paginas);
        criarPaginaAvanco(paginas);
        criarPaginasAtalhoFim(paginas);
        return paginas;
    }

    private  void criarPaginasAtalhoInicio(List<Pagina> paginas) {
        paginas.add(new Pagina("<<", 1));
        paginas.add(new Pagina("<", registroPaginado.getPagina() > 1 ? registroPaginado.getPagina()-1 : 1));
    }

    private  void criarPaginas(List<Pagina> paginas) {
        Integer inicio = getPaginaInicio();
        Integer fim = getPaginaFim();
        for (int i = inicio ; i <=fim; i++){
            paginas.add(new Pagina(i, i == registroPaginado.getPagina()));
        }
    }

    private  void criarPaginaAvanco(List<Pagina> paginas) {
        if(registroPaginado.getTotalPaginas() > quantidadePaginas) {
            int avanco = getPaginaInicio() + quantidadeAvancoPaginas;
            if (avanco > registroPaginado.getTotalPaginas()) {
                avanco = registroPaginado.getTotalPaginas();
            }
            paginas.add(new Pagina("...", null));
            paginas.add(new Pagina(avanco, avanco == registroPaginado.getPagina()));
        }
    }

    private  void criarPaginasAtalhoFim(List<Pagina> paginas) {
        paginas.add(new Pagina(">", registroPaginado.getPagina() < registroPaginado.getTotalPaginas() ? registroPaginado.getPagina()+1 : registroPaginado.getTotalPaginas()));
        paginas.add(new Pagina(">>", registroPaginado.getTotalPaginas()));
    }

    private  Integer getPaginaInicio(){
        int pagina = registroPaginado.getPagina();
        int inicio = ((pagina/quantidadePaginas)*quantidadePaginas)+1;
        if(pagina % quantidadePaginas == 0){
            inicio--;
        }
        if(inicio + quantidadePaginas > registroPaginado.getTotalPaginas()){
            inicio = registroPaginado.getTotalPaginas() - quantidadePaginas;
        }
        if(inicio < 1){
            inicio = 1;
        }
        return inicio;
    }

    private  Integer getPaginaFim(){
        int fim = getPaginaInicio() + quantidadePaginas -1;
        if(fim > registroPaginado.getTotalPaginas()){
            fim = registroPaginado.getTotalPaginas();
        }
        return fim;
    }



}
