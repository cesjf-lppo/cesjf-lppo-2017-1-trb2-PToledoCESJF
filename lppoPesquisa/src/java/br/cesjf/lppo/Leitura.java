package br.cesjf.lppo;

import java.sql.Timestamp;

public class Leitura {
    private int idLeitura;
    private int coleta;
    private String localLeitura;
    private float leitura;
    private String unidade;
    private Timestamp atualizacao;

    public int getIdLeitura() {
        return idLeitura;
    }

    public void setIdLeitura(int idLeitura) {
        this.idLeitura = idLeitura;
    }

    public int getColeta() {
        return coleta;
    }

    public void setColeta(int coleta) {
        this.coleta = coleta;
    }

    public String getLocalLeitura() {
        return localLeitura;
    }

    public void setLocalLeitura(String localLeitura) {
        this.localLeitura = localLeitura;
    }

    public float getLeitura() {
        return leitura;
    }

    public void setLeitura(float leitura) {
        this.leitura = leitura;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Timestamp getAtualizacao() {
        return atualizacao;
    }

    public void setAtualizacao(Timestamp atualizacao) {
        this.atualizacao = atualizacao;
    }
    
    
    
}
