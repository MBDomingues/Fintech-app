package br.com.fintech.modules;

public class ResumoFinanceiro {
    private int cdResumo;
    private String mesAno;
    private float totalRenda;
    private float totalGasto;
    private float saldoDisponivel;
    private float vlFaltanteMeta;

    public ResumoFinanceiro(int cdResumo, String mesAno, float totalRenda, float totalGasto, float saldoDisponivel, float vlFaltanteMeta) {
        this.cdResumo = cdResumo;
        this.mesAno = mesAno;
        this.totalRenda = totalRenda;
        this.totalGasto = totalGasto;
        this.saldoDisponivel = saldoDisponivel;
        this.vlFaltanteMeta = vlFaltanteMeta;
    }

    public int getCdResumo() {
        return cdResumo;
    }

    public void setCdResumo(int cdResumo) {
        this.cdResumo = cdResumo;
    }

    public String getMesAno() {
        return mesAno;
    }

    public void setMesAno(String mesAno) {
        this.mesAno = mesAno;
    }

    public float getTotalRenda() {
        return totalRenda;
    }

    public void setTotalRenda(float totalRenda) {
        this.totalRenda = totalRenda;
    }

    public float getTotalGasto() {
        return totalGasto;
    }

    public void setTotalGasto(float totalGasto) {
        this.totalGasto = totalGasto;
    }

    public float getSaldoDisponivel() {
        return saldoDisponivel;
    }

    public void setSaldoDisponivel(float saldoDisponivel) {
        this.saldoDisponivel = saldoDisponivel;
    }

    public float getVlFaltanteMeta() {
        return vlFaltanteMeta;
    }

    public void setVlFaltanteMeta(float vlFaltanteMeta) {
        this.vlFaltanteMeta = vlFaltanteMeta;
    }
}
