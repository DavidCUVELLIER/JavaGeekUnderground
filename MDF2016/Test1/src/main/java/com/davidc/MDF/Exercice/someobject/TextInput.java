/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice.someobject;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author cuvellierdavid
 */
public class TextInput {
    private List<String> lines;
    private TextOutput textOutput;

    public TextInput(){
        lines = new ArrayList<String>();
        textOutput = new TextOutput();
    }
    /**
     * @return the line
     */
    public List<String> getLine() {
        return lines;
    }

    /**
     * @param line the line to set
     */
    public void setLine(List<String> line) {
        this.lines = line;
    }
    
    public void addLine(String line1){
        lines.add(line1);
    }
    
    public String[] lineToListMots(int lineNumber){
        return lines.get(lineNumber).split("");
    }
    
    public void generate(){
        List<MotOccurence> motOccurences = new ArrayList<>();
        lines.stream().forEach((line) -> {
            String[] words = line.split(" ");
            for ( String word : words){                
                textOutput.addMot(word.toLowerCase());
            }
        });
    }

    public Integer[] order3(Integer occ, Integer a,
            Integer b,Integer c,
            Integer max){
        Integer[] result = new Integer[3];

        if (occ == max) {}
        else if (a <= occ ) {c=b; b=a ; a=occ;}
        else if ( b <= occ ) { c=b;b=occ;}
        else if ( c <= occ ) { c =occ;} 
        result[0] = a;
        result[1] = b;
        result[2] = c;
        return result;
    }
    
    public void clean(){
        List<String> motToRemove = new ArrayList<>();
        Integer[] ordered = new Integer[]{0,0,0};
        for ( String mot : textOutput.getMotOccurence().keySet()){
            Integer occ = textOutput.getMotOccurence().get(mot);
            ordered = order3(occ, ordered[0], ordered[1], ordered[2],lines.size() );           
            if (occ >= lines.size()){
                motToRemove.add(mot);
            }
        }
        
        for ( String mot : textOutput.getMotOccurence().keySet()){
            for (String line : lines){
                String[] array = line.split(mot);
                if (array.length > 2){
                    motToRemove.add(mot);
                }
            }
        }
        
        for ( String mot : textOutput.getMotOccurence().keySet()){
            Integer occ = textOutput.getMotOccurence().get(mot);
            if ((occ >= lines.size()) || (
                    (occ != ordered[0]) &&
                    (occ != ordered[1]) &&
                    (occ != ordered[2]))){
                motToRemove.add(mot);
            }
        }        
        for (String mot : motToRemove){
            textOutput.getMotOccurence().remove(mot);
        }
    }
    /**
     * @return the textOutput
     */
    public TextOutput getTextOutput() {
        return textOutput;
    }

    /**
     * @param textOutput the textOutput to set
     */
    public void setTextOutput(TextOutput textOutput) {
        this.textOutput = textOutput;
    }
    
}
