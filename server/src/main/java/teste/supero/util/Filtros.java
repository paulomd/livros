package teste.supero.util;

import javax.ws.rs.QueryParam;

public class Filtros {

    @QueryParam("filtro")
    private String filtro;

    @QueryParam("anoInicial")
    private Integer anoInicial;

    @QueryParam("anoFinal")
    private Integer anoFinal;

    public Integer getAnoInicial() {
        return anoInicial;
    }

    public void setAnoInicial(Integer anoInicial) {
        this.anoInicial = anoInicial;
    }

    public Integer getAnoFinal() {
        return anoFinal;
    }

    public void setAnoFinal(Integer anoFinal) {
        this.anoFinal = anoFinal;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
}
