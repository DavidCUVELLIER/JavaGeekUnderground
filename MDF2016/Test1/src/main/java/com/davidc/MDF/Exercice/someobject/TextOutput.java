/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice.someobject;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;

/**
 *
 * @author cuvellierdavid
 */
public class TextOutput implements Comparable<Object>{
    private Map<String,Integer> motOccurences;

    public TextOutput(){
        motOccurences = new HashMap<String,Integer>();
    }
    /**
     * @return the motOccurence
     */
    public Map<String,Integer> getMotOccurence() {
        return motOccurences;
    }

    /**
     * @param motOccurence the motOccurence to set
     */
    public void setMotOccurence(Map<String,Integer> motOccurence) {
        this.motOccurences = motOccurence;
    }
 
    public void addMot(String mot){
        Integer occurence = motOccurences.get(mot);
        if (occurence == null){
            occurence = 1;}
        else{
            occurence++;
        }
        motOccurences.put(mot,occurence);
    }

        public void addMotOcurrence(String mot,Integer occurence){
        motOccurences.put(mot,occurence);
    }
        
    @Override
    public int compareTo(Object o) {
        TextOutput to = (TextOutput) o;
        for(String key : to.getMotOccurence().keySet()){
            Integer occ2 = to.getMotOccurence().get(key);
            Integer occ1 = this.getMotOccurence().get(key);
            if (occ1 != occ2){
                return -1;
            }
        }        
        return 0;
    }
}
