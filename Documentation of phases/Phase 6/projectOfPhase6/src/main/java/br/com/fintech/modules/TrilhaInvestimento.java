package br.com.fintech.modules;

public class TrilhaInvestimento {
    private int cdTrilha;
    private int cdMeta;
    private int nmConta;
    private int cdUsuario;
    private float vlInvestido;
    private String tipoInvestimento;
    private float vlAplicado;
    private float rentabilidade;
    private String prazo;
    private String risco;
    private String transacao;

    public TrilhaInvestimento(int cdTrilha, int cdMeta, int nmConta, int cdUsuario, float vlInvestido, String tipoInvestimento, float vlAplicado, float rentabilidade, String prazo, String risco, String transacao) {
        this.cdTrilha = cdTrilha;
        this.cdMeta = cdMeta;
        this.nmConta = nmConta;
        this.cdUsuario = cdUsuario;
        this.vlInvestido = vlInvestido;
        this.tipoInvestimento = tipoInvestimento;
        this.vlAplicado = vlAplicado;
        this.rentabilidade = rentabilidade;
        this.prazo = prazo;
        this.risco = risco;
        this.transacao = transacao;
    }

    public int getCdTrilha() {
        return cdTrilha;
    }

    public void setCdTrilha(int cdTrilha) {
        this.cdTrilha = cdTrilha;
    }

    public int getNmConta() {
        return nmConta;
    }

    public void setNmConta(int nmConta) {
        this.nmConta = nmConta;
    }

    public int getCdMeta() {
        return cdMeta;
    }

    public void setCdMeta(int cdMeta) {
        this.cdMeta = cdMeta;
    }

    public int getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(int cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public float getVlInvestido() {
        return vlInvestido;
    }

    public void setVlInvestido(float vlInvestido) {
        this.vlInvestido = vlInvestido;
    }

    public String getTipoInvestimento() {
        return tipoInvestimento;
    }

    public void setTipoInvestimento(String tipoInvestimento) {
        this.tipoInvestimento = tipoInvestimento;
    }

    public float getVlAplicado() {
        return vlAplicado;
    }

    public void setVlAplicado(float vlAplicado) {
        this.vlAplicado = vlAplicado;
    }

    public float getRentabilidade() {
        return rentabilidade;
    }

    public void setRentabilidade(float rentabilidade) {
        this.rentabilidade = rentabilidade;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public String getTransacao() {
        return transacao;
    }

    public void setTransacao(String transacao) {
        this.transacao = transacao;
    }
}
