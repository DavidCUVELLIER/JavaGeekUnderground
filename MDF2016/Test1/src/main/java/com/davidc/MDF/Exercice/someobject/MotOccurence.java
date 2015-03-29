/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice.someobject;


/**
 *
 * @author cuvellierdavid
 */
public class MotOccurence {
    private Integer occurence;
    private String mot;

    public MotOccurence(String in){
        String[] inSplitted = in.split(" ");
        occurence = Integer.parseInt(inSplitted[0]);
        mot = inSplitted[1];
    }
    /**
     * @return the occurence
     */
    public Integer getOccurence() {
        return occurence;
    }

    /**
     * @param occurence the occurence to set
     */
    public void setOccurence(Integer occurence) {
        this.occurence = occurence;
    }

    /**
     * @return the mot
     */
    public String getMot() {
        return mot;
    }

    /**
     * @param mot the mot to set
     */
    public void setMot(String mot) {
        this.mot = mot;
    }
}
