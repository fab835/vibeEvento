package eventos.com.vibe.app.vibeeventos.model;

public class Event {

    private int id;
    private String nome;
    private String imagem;
    private boolean UsarImpressora;
    private boolean capturarAssinatura;
    private String inicio;
    private String quando;
    private String local;

    public Event(int id, String nome, String imagem, boolean usarImpressora, boolean capturarAssinatura, String inicio, String quando, String local) {
        this.id = id;
        this.nome = nome;
        this.imagem = imagem;
        UsarImpressora = usarImpressora;
        this.capturarAssinatura = capturarAssinatura;
        this.inicio = inicio;
        this.quando = quando;
        this.local = local;
    }

    public Event(){

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

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public boolean isUsarImpressora() {
        return UsarImpressora;
    }

    public void setUsarImpressora(boolean usarImpressora) {
        UsarImpressora = usarImpressora;
    }

    public boolean isCapturarAssinatura() {
        return capturarAssinatura;
    }

    public void setCapturarAssinatura(boolean capturarAssinatura) {
        this.capturarAssinatura = capturarAssinatura;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getQuando() {
        return quando;
    }

    public void setQuando(String quando) {
        this.quando = quando;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
