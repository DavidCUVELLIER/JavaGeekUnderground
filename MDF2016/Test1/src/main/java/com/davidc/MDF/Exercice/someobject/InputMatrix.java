/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice.someobject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author cuvellierdavid
 */
public class InputMatrix {
    private Integer sizeMatrix;
    private List<LineMatrix> lineMaxtrixs;
    private OutPutMatrix outPutMatrix;
    /**
     * @return the sizeMatrix
     */
    public Integer getSizeMatrix() {
        return sizeMatrix;
    }

    /**
     * @param sizeMatrix the sizeMatrix to set
     */
    public void setSizeMatrix(Integer sizeMatrix) {
        this.sizeMatrix = sizeMatrix;
    }

    /**
     * @return the lineMaxtrixs
     */
    public List<LineMatrix> getLineMaxtrixs() {
        return lineMaxtrixs;
    }

    /**
     * @param lineMaxtrixs the lineMaxtrixs to set
     */
    public void setLineMaxtrixs(List<LineMatrix> lineMaxtrixs) {
        this.lineMaxtrixs = lineMaxtrixs;
    }
    
    public void generate(){
        outPutMatrix = new OutPutMatrix(Integer.MAX_VALUE, Integer.MIN_VALUE, Double.NaN, 0);
        Integer count = 1;
        Double SumOfVal = 0.0;
        Map<Integer,Integer> dicoMode = new HashMap<Integer, Integer>();
        Integer mostFrequentOccurValue=0;
        for (LineMatrix lineMatrix : lineMaxtrixs ){
            for ( Integer val : lineMatrix.getElememts()){
                if ( val < outPutMatrix.getMin()){
                    outPutMatrix.setMin(val);}
                if ( val > outPutMatrix.getMax()){
                    outPutMatrix.setMax(val);}
                SumOfVal = SumOfVal + val;
                double b = (SumOfVal / count);
                System.out.println(SumOfVal +"/"+ count);
                outPutMatrix.setMediane(b);
                Integer nbOccurElt = 1;
                if (dicoMode.containsKey(val)){
                    nbOccurElt = dicoMode.get(val) + 1;
                }
                dicoMode.put(val, nbOccurElt);
                if (nbOccurElt > mostFrequentOccurValue){
                    mostFrequentOccurValue = nbOccurElt;
                }
                count++;
            }
        }
        
        List<Integer> dicMostFrequentOccur = new ArrayList<Integer>();
        for (Integer c : dicoMode.keySet()){
            if ( dicoMode.get(c) == mostFrequentOccurValue ){
                dicMostFrequentOccur.add(c);
            }
        }
        
        Integer minModeValue = Integer.MAX_VALUE;
        for (Integer c : dicMostFrequentOccur){
            if ( minModeValue > c){
                minModeValue = c;
            }
        }
        outPutMatrix.setMode(minModeValue);

    }

    /**
     * @return the outPutMatrix
     */
    public OutPutMatrix getOutPutMatrix() {
        return outPutMatrix;
    }

    /**
     * @param outPutMatrix the outPutMatrix to set
     */
    public void setOutPutMatrix(OutPutMatrix outPutMatrix) {
        this.outPutMatrix = outPutMatrix;
    }
}
