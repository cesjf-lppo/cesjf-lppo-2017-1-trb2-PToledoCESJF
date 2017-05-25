package br.cesjf.lppo;

import java.util.Date;

public class Coleta {
    private int idColeta;
    private String descricao;
    private Date dataColeta;

    public int getIdColeta() {
        return idColeta;
    }

    public void setIdColeta(int idColeta) {
        this.idColeta = idColeta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataColeta() {
        return dataColeta;
    }

    public void setData(Date dataColeta) {
        this.dataColeta = dataColeta;
    }
    
}
