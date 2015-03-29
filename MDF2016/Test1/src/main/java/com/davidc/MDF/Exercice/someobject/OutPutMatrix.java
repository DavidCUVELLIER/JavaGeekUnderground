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
public class OutPutMatrix {
    private Integer min;
    private Integer max;
    private Double mediane;
    private Integer mode;

    public OutPutMatrix(){        
    }
    
    public OutPutMatrix(Integer min1,Integer max1,
            Double mediane1, Integer mode1){
        min = min1;
        max = max1;
        mediane = mediane1;
        mode = mode1;
    }
    
    public String toString(){
        return min.toString() + " " + max.toString() + " " + mediane.toString() + " " + mode.toString();
    }
    
    /**
     * @return the min
     */
    public Integer getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(Integer min) {
        this.min = min;
    }

    /**
     * @return the max
     */
    public Integer getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(Integer max) {
        this.max = max;
    }

    /**
     * @return the mediane
     */
    public Double getMediane() {
        return mediane;
    }

    /**
     * @param mediane the mediane to set
     */
    public void setMediane(Double mediane) {
        this.mediane = mediane;
    }

    /**
     * @return the mode
     */
    public Integer getMode() {
        return mode;
    }

    /**
     * @param mode the mode to set
     */
    public void setMode(Integer mode) {
        this.mode = mode;
    }
}
