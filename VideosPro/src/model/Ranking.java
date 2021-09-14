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
public class Ranking {
    private int contId;
    private String nombreCont;
    private int vis;
    
    public Ranking(int contId, String nombreCont, int vis){
        this.contId = contId;
        this.nombreCont = nombreCont;
        this.vis = vis;
    }

    /**
     * @return the contId
     */
    public int getContId() {
        return contId;
    }

    /**
     * @return the nombreCont
     */
    public String getNombreCont() {
        return nombreCont;
    }

    /**
     * @param nombreCont the nombreCont to set
     */
    public void setNombreCont(String nombreCont) {
        this.nombreCont = nombreCont;
    }

    /**
     * @return the vis
     */
    public int getVis() {
        return vis;
    }
}
