package eventos.com.vibe.app.vibeeventos.model;

public class Paginator {

    private int pagina;
    private int totalPaginas;
    private int registroPorPagina;
    private int totalRegistros;

    public Paginator(int pagina, int totalPaginas, int registroPorPagina, int totalRegistros) {
        this.pagina = pagina;
        this.totalPaginas = totalPaginas;
        this.registroPorPagina = registroPorPagina;
        this.totalRegistros = totalRegistros;
    }

    public Paginator(){

    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public int getRegistroPorPagina() {
        return registroPorPagina;
    }

    public void setRegistroPorPagina(int registroPorPagina) {
        this.registroPorPagina = registroPorPagina;
    }

    public int getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(int totalRegistros) {
        this.totalRegistros = totalRegistros;
    }
}
