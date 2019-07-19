package teste.supero.dao;

import teste.supero.models.Livro;
import teste.supero.models.RegistroPaginado;
import teste.supero.util.Filtros;
import teste.supero.util.ParametroPaginacao;

public class LivroDao extends GenericDao<Livro> {

    public RegistroPaginado<Livro> buscarLivro(Filtros filtros, ParametroPaginacao parametroPaginacao){
        String filtroFormatado = getFiltroFormatado(filtros);
        RegistroPaginado<Livro> registroPaginado = buscarRegistros(filtroFormatado, parametroPaginacao);
        return registroPaginado;
    }

    private String getFiltroFormatado(Filtros filtros) {
        String retorno = "1=1 ";
        if(filtros.getFiltro() != null){
            retorno += " and ( titulo like '%"+filtros.getFiltro()+"%'";
            retorno += " or autor like '%"+filtros.getFiltro()+"%'";
            if(isNumeric(filtros.getFiltro())) {
                retorno += " or isbn = " + filtros.getFiltro();
            }
            retorno +=  ") ";
        }
        if(filtros.getAnoInicial() != null ){
            retorno += " and  ano >= "+filtros.getAnoInicial();
        }
        if(filtros.getAnoFinal() != null ){
            retorno += " and  ano <= "+filtros.getAnoFinal();
        }
        return retorno;
    }

    public  boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

}
