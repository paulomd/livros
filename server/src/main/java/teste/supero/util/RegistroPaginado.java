package teste.supero.util;

import teste.supero.util.ParametroPaginacao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.List;

public class RegistroPaginado<T> {

    private Integer pagina;
    private Integer totalPaginas;
    private Integer totalRegistros;
    private Integer registrosPorPagina;

    private List<T> registros;

    private List<Pagina> paginas;

    public RegistroPaginado() {

    }

    public RegistroPaginado(ParametroPaginacao parametroPaginacao) {
        this.pagina = parametroPaginacao.getPagina();
        this.registrosPorPagina = parametroPaginacao.getRegistrosPorPagina();
    }

    public Integer getPagina() {
        return pagina;
    }

    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }

    public Integer getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(Integer totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public Integer getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(Integer totalRegistros) {
        this.totalRegistros = totalRegistros;
        calcTotalPaginas();
        criarPaginas();
    }

    public Integer getRegistrosPorPagina() {
        return registrosPorPagina;
    }

    public void setRegistrosPorPagina(Integer registrosPorPagina) {
        this.registrosPorPagina = registrosPorPagina;
    }

    public List<T> getRegistros() {
        return registros;
    }

    public void setRegistros(List<T> registros) {
        this.registros = registros;
    }

    public List<Pagina> getPaginas() {
        return paginas;
    }

    public void setPaginas(List<Pagina> paginas) {
        this.paginas = paginas;
    }

    private void calcTotalPaginas() {
         Integer calc = (int) ((getTotalRegistros() / getRegistrosPorPagina()));
         if(calc * getRegistrosPorPagina() < getTotalRegistros()){
             calc++;
         }
         setTotalPaginas(calc);
    }

    private void criarPaginas(){
        setPaginas(new PaginacaoUtil(this).criarPaginas());
    }
}
