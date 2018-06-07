package eventos.com.vibe.app.vibeeventos.model;

public class ParticipantDetail {

    private int Id;
    private String Nome;
    private String Email;
    private String Assinatura;
    private String DataCadastro;
    private String CheckIn;

    public ParticipantDetail(int Id, String Nome, String Email, String Assinatura, String DataCadastro, String CheckIn) {
        this.Id = Id;
        this.Nome = Nome;
        this.Email = Email;
        this.Assinatura = Assinatura;
        this.DataCadastro = DataCadastro;
        this.CheckIn = CheckIn;
    }

    public ParticipantDetail(){

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAssinatura() {
        return Assinatura;
    }

    public void setAssinatura(String assinatura) {
        Assinatura = assinatura;
    }

    public String getDataCadastro() {

        if (DataCadastro == null){
            return "Sem Data de Cadastro";
        }

        String date[]  = DataCadastro.split("T")[0].split("-");
        String hora[] = DataCadastro.split("T")[1].split(":");
        return date[2]+"/"+date[1]+"/"+date[0] + " às " + hora[0]+":"+hora[1];
    }

    public void setDataCadastro(String dataCadastro) {
        DataCadastro = dataCadastro;
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
        CheckIn = checkIn;
    }
}
