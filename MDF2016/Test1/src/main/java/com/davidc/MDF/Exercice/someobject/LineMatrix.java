/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice.someobject;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuvellierdavid
 */
public class LineMatrix {
    private List<Integer> elememts;
    
    public LineMatrix(){
        elememts = new ArrayList<Integer>();
    }
    public LineMatrix(List<Integer> elets){
        elememts = elets;
    }

    /**
     * @return the elememts
     */
    public List<Integer> getElememts() {
        return elememts;
    }

    /**
     * @param elememts the elememts to set
     */
    public void setElememts(List<Integer> elememts) {
        this.elememts = elememts;
    }
}
