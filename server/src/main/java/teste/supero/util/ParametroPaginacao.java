package teste.supero.util;

import javax.ws.rs.QueryParam;

public class ParametroPaginacao {

    @QueryParam("pagina")
    private Integer pagina;

    @QueryParam("registrosPorPagina")
    private Integer registrosPorPagina;

    public Integer getPagina() {
        return pagina != null ? pagina : 1;
    }

    public Integer getRegistrosPorPagina() {
        return registrosPorPagina != null ? registrosPorPagina : 10;
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
