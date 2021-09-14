/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author alejandro
 */
public class Transmision {

    private int transId;
    private String transFecha;
    private int transContId;
    private String transAlias;
    
    public Transmision(){
        
    }
    public Transmision(int transId, String transFecha, int transContId, String transAlias){
        this.transId = transId;
        this.transFecha = transFecha;
        this.transContId = transContId;
        this.transAlias = transAlias;
    }
    
    /**
     * @return the transId
     */
    public int getTransId() {
        return transId;
    }

    /**
     * @return the transFecha
     */
    public String getTransFecha() {
        return transFecha;
    }

    /**
     * @param transFecha the transFecha to set
     */
    public void setTransFecha(String transFecha) {
        this.transFecha = transFecha;
    }

    /**
     * @return the transContId
     */
    public int getTransContId() {
        return transContId;
    }

    /**
     * @param transContId the transContId to set
     */
    public void setTransContId(int transContId) {
        this.transContId = transContId;
    }

    /**
     * @return the transAlias
     */
    public String getTransAlias() {
        return transAlias;
    }

    /**
     * @param transId the transId to set
     */
    public void setTransId(int transId) {
        this.transId = transId;
    }
}
