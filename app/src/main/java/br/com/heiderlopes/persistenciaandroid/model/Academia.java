package br.com.heiderlopes.persistenciaandroid.model;

/**
 * Created by heiderlopes on 08/01/16.
 */
public class Academia {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEXEMPLO_SAIDA() {
        return EXEMPLO_SAIDA;
    }

    public void setEXEMPLO_SAIDA(String EXEMPLO_SAIDA) {
        this.EXEMPLO_SAIDA = EXEMPLO_SAIDA;
    }

    public String getSAÍDA() {
        return SAÍDA;
    }

    public void setSAÍDA(String SAÍDA) {
        this.SAÍDA = SAÍDA;
    }

    public String getEXEMPLO_ENTRADA() {
        return EXEMPLO_ENTRADA;
    }

    public void setEXEMPLO_ENTRADA(String EXEMPLO_ENTRADA) {
        this.EXEMPLO_ENTRADA = EXEMPLO_ENTRADA;
    }

    public String getCODIGO_FONTE() {
        return CODIGO_FONTE;
    }

    public void setCODIGO_FONTE(String CODIGO_FONTE) {
        this.CODIGO_FONTE = CODIGO_FONTE;
    }

    public String getENTRADA() {
        return ENTRADA;
    }

    public void setENTRADA(String ENTRADA) {
        this.ENTRADA = ENTRADA;
    }

    public String getPROBLEMA() {
        return PROBLEMA;
    }

    public void setPROBLEMA(String PROBLEMA) {
        this.PROBLEMA = PROBLEMA;
    }

    public String getTITULO() {
        return TITULO;
    }

    public void setTITULO(String TITULO) {
        this.TITULO = TITULO;
    }

    private int id;
    private String TITULO;
    private String PROBLEMA;
    private String ENTRADA;
    private String CODIGO_FONTE;
    private String SAÍDA;
    private String EXEMPLO_ENTRADA;
    private String EXEMPLO_SAIDA;


}




