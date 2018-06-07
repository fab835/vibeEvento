package eventos.com.vibe.app.vibeeventos.model;

public class ListParticipants {
    private int Id;
    private String Nome;
    private String CheckIn;

    public ListParticipants(int Id, String Nome, String CheckIn) {
        this.Id = Id;
        this.Nome = Nome;
        this.CheckIn = CheckIn;
    }

    public ListParticipants(){

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNome() {
        if(Nome == null){
            return "Sem Nome";
        }
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getCheckIn() {
        if (CheckIn == null){
            return null;
        }

        String date[]  = CheckIn.split("T")[0].split("-");
        String hora[] = CheckIn.split("T")[1].split(":");
        return date[2]+"/"+date[1]+"/"+date[0] + " às " + hora[0]+":"+hora[1];
    }

    public void setCheckIn(String checkIn) {
        this.CheckIn = checkIn;
    }
}
