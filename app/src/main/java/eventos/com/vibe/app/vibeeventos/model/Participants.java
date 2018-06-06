package eventos.com.vibe.app.vibeeventos.model;

import java.util.List;

public class Participants {

    private List<ListParticipants> lista;
    private Paginator paginator;

    public Participants(List<ListParticipants> lista, Paginator paginator) {
        this.lista = lista;
        this.paginator = paginator;
    }

    public Participants(){

    }

    public List<ListParticipants> getLista() {
        return lista;
    }

    public void setLista(List<ListParticipants> lista) {
        this.lista = lista;
    }

    public Paginator getPaginator() {
        return paginator;
    }

    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;
    }
}
