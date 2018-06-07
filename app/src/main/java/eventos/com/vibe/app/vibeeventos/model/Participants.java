package eventos.com.vibe.app.vibeeventos.model;

import java.util.List;

public class Participants {

    private List<ListParticipants> Lista;
    private Paginator Paginador;

    public Participants(List<ListParticipants> Lista, Paginator Paginador) {
        this.Lista = Lista;
        this.Paginador = Paginador;
    }

    public Participants(){

    }

    public List<ListParticipants> getLista() {
        return Lista;
    }

    public void setLista(List<ListParticipants> lista) {
        this.Lista = lista;
    }

    public Paginator getPaginator() {
        return Paginador;
    }

    public void setPaginator(Paginator paginador) {
        this.Paginador = paginador;
    }
}
