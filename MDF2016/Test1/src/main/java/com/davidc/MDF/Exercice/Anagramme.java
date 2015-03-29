/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice;

/**
 *
 * @author cuvellierdavid
 */
public class Anagramme {
    Integer input;
    int[] intToArrayOfInt(Integer i){
        String iToString = i.toString();
        int[] arrayNbOcc = new int[10];
        for (int j=0; j< iToString.length(); j++){
            String a = Character.toString(iToString.charAt(j));
            arrayNbOcc[Integer.parseInt(a)]++;
        }
       return arrayNbOcc;
    }

    int compute(){
        for ( int i=1; i < 1000000 ; i ++){
            boolean isSame = false;
            int[] res1 = intToArrayOfInt(i);
            int[] res2 = intToArrayOfInt(i*2);
            int[] res3 = intToArrayOfInt(i*3);
            int[] res4 = intToArrayOfInt(i*4);
            int[] res5 = intToArrayOfInt(i*5);
            int[] res6 = intToArrayOfInt(i*6);
            if (isSameArray(res1,res2,res3,res4,res5,res6)) {isSame = true;};
            if (isSame) { return i;}
            
        }
        return -1;
    }
    
    boolean isSameArray(int[] res1, int[] res2,
            int[] res3, int[] res4,
            int[] res5, int[] res6){
        for ( int i = 0; i< 10 ; i++){
            if ((res1[i] != res2[i]) ||
                    (res2[i] != res3[i]) ||
                    (res3[i] != res4[i])||
                    (res4[i] != res5[i])||
                    (res5[i] != res6[i])){
                return false;
            }
        }
        return true;
    }
}
