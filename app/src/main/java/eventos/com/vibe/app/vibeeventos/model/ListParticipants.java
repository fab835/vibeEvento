package eventos.com.vibe.app.vibeeventos.model;

public class ListParticipants {
    private int id;
    private String nome;
    private String checkIn;

    public ListParticipants(int id, String nome, String checkIn) {
        this.id = id;
        this.nome = nome;
        this.checkIn = checkIn;
    }

    public ListParticipants(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }
}
