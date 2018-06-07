package eventos.com.vibe.app.vibeeventos.model;

public class Paginator {

    private int pagina;
    private int TotalPaginas;
    private int RegistroPorPagina;
    private int TotalRegistros;

    public Paginator(int Pagina, int TotalPaginas, int RegistroPorPagina, int TotalRegistros) {
        this.pagina = Pagina;
        this.TotalPaginas = TotalPaginas;
        this.RegistroPorPagina = RegistroPorPagina;
        this.TotalRegistros = TotalRegistros;
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
        return TotalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.TotalPaginas = totalPaginas;
    }

    public int getRegistroPorPagina() {
        return RegistroPorPagina;
    }

    public void setRegistroPorPagina(int registroPorPagina) {
        this.RegistroPorPagina = registroPorPagina;
    }

    public int getTotalRegistros() {
        return TotalRegistros;
    }

    public void setTotalRegistros(int totalRegistros) {
        this.TotalRegistros = totalRegistros;
    }
}
