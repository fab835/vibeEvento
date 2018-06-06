package eventos.com.vibe.app.vibeeventos.model;

public class Event {

    private int Id;
    private String Nome;
    private String Imagem;
    private boolean UsarImpressora;
    private boolean CapturarAssinatura;
    private String ClienteImagem;
    private String Inicio;
    private String Quando;
    private String Local;

    public Event(int id, String nome, String imagem, boolean usarImpressora, boolean capturarAssinatura, String clienteImagem, String inicio, String quando, String local) {
        this.Id = id;
        this.Nome = nome;
        this.Imagem = imagem;
        UsarImpressora = usarImpressora;
        this.CapturarAssinatura = capturarAssinatura;
        this.ClienteImagem = clienteImagem;
        this.Inicio = inicio;
        this.Quando = quando;
        this.Local = local;
    }

    public String getClienteImagem() {
        return ClienteImagem;
    }

    public void setClienteImagem(String clienteImagem) {
        this.ClienteImagem = clienteImagem;
    }

    public Event(){

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getImagem() {
        return Imagem;
    }

    public void setImagem(String imagem) {
        this.Imagem = imagem;
    }

    public boolean isUsarImpressora() {
        return UsarImpressora;
    }

    public void setUsarImpressora(boolean usarImpressora) {
        UsarImpressora = usarImpressora;
    }

    public boolean isCapturarAssinatura() {
        return CapturarAssinatura;
    }

    public void setCapturarAssinatura(boolean capturarAssinatura) {
        this.CapturarAssinatura = capturarAssinatura;
    }

    public String getInicio() {
        String date[]  = Inicio.split("T")[0].split("-");
        String hora[] = Inicio.split("T")[1].split(":");
        return date[2]+"/"+date[1]+"/"+date[0] + " às " + hora[0]+":"+hora[1];
    }

    public void setInicio(String inicio) {
        this.Inicio = inicio;
    }

    public String getQuando() {
        return Quando;
    }

    public void setQuando(String quando) {
        this.Quando = quando;
    }

    public String getLocal() {
        return Local;
    }

    public void setLocal(String local) {
        this.Local = local;
    }
}
