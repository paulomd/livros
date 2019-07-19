package teste.supero.util;

public class Pagina {

    private String descricao;
    private Integer pagina;
    private Boolean selecionada;

    public Pagina(String descricao, Integer pagina) {
        this.descricao = descricao;
        this.pagina = pagina;
        this.selecionada = false;
    }

    public Pagina(Integer pagina, Boolean selecionada) {
        this.descricao = pagina.toString();
        this.pagina = pagina;
        this.selecionada = selecionada;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getPagina() {
        return pagina;
    }

    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }

    public Boolean getSelecionada() {
        return selecionada;
    }

    public void setSelecionada(Boolean selecionada) {
        this.selecionada = selecionada;
    }
}
