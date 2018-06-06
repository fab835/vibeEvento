package eventos.com.vibe.app.vibeeventos.model;

public class ParticipantDetail {

    private int id;
    private String nome;
    private String email;
    private String assinatura;
    private String dataCadastro;
    private String checkIn;

    public ParticipantDetail(int id, String nome, String email, String assinatura, String dataCadastro, String checkIn) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.assinatura = assinatura;
        this.dataCadastro = dataCadastro;
        this.checkIn = checkIn;
    }

    public ParticipantDetail(){

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(String assinatura) {
        this.assinatura = assinatura;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }
}
