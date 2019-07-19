package teste.supero.util;

import javax.ws.rs.QueryParam;

public class ParametroPaginacao {

    private Integer paginaPadrao = 1;
    private Integer registrosPorPaginaPadrao = 10;

    @QueryParam("pagina")
    private Integer pagina;

    @QueryParam("registrosPorPagina")
    private Integer registrosPorPagina;

    public Integer getPagina() {
        return pagina != null ? pagina : paginaPadrao;
    }

    public Integer getRegistrosPorPagina() {
        return registrosPorPagina != null ? registrosPorPagina : registrosPorPaginaPadrao;
    }

    public void setRegistrosPorPagina(Integer registrosPorPagina) {
        this.registrosPorPagina = registrosPorPagina;
    }

    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }

    public Integer getInicio(){
        return (getPagina()-1) * getRegistrosPorPagina();
    }
}
