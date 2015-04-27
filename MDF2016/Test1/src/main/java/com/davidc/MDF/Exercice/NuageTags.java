/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author cuvellierdavid
 */
public class NuageTags {
    int nbTags = 0;
    List<String> tags = new ArrayList<>();
    Map<String,Integer> resultExpected = new HashMap<>();
    Map<String,Integer> resultComputed = new HashMap<>();
    
    public Boolean launchCompute(String in, String out) throws FileNotFoundException, URISyntaxException{
        InputStream IS,OS;
        URL resourceIN = this.getClass().getClassLoader().getResource(in);
        URL resourceOUT = this.getClass().getClassLoader().getResource(out);
        IS = new FileInputStream(new File(resourceIN.toURI()));
        OS = new FileInputStream(new File(resourceOUT.toURI()));
        return compute(IS, OS);
    }
    
    boolean compute (InputStream IS, InputStream OS){
        readInputFile(IS);
        readOutputFile(OS);
        String previousWord = tags.get(0);
        Integer count = 0;
        for (int i = 1 ; i < tags.size() ; i++ ) {
            if (tags.get(i).compareToIgnoreCase(previousWord) != 0){
                resultComputed.put(previousWord, count);
                previousWord = tags.get(i);
                count = 1;
            }
            else{
                count ++;
            }
        }
        resultComputed.put(previousWord, count);
                
        Object[] resultComputedSorted = resultComputed.entrySet().toArray();
        Arrays.sort(resultComputedSorted, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<String, Integer>) o2).getValue().compareTo(
                        ((Map.Entry<String, Integer>) o1).getValue());
            }
        });

        Object[] resultExpectedArraySorted = resultExpected.entrySet().toArray();
        Arrays.sort(resultExpectedArraySorted, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<String, Integer>) o2).getValue().compareTo(
                        ((Map.Entry<String, Integer>) o1).getValue());
            }
        }); 
        int i =0;
        for (Object e : resultComputedSorted) {
            String computedkey = ((Map.Entry<String, Integer>) e).getKey();
            String expectedkey = ((Map.Entry<String, Integer>) resultExpectedArraySorted[i]).getKey();
            i++;
            if (computedkey.compareToIgnoreCase(expectedkey) ==0){
                if (i == 5){
                    return true;
                }
            }else{
                return false;
            }

        }
        return false;
    }
    void readInputFile(InputStream IS ){
        Scanner sc = new Scanner(IS);
        nbTags = Integer.parseInt(sc.nextLine());
        tags.clear();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            tags.add(line);
        }
        Collections.sort(tags);
    }
    
    void readOutputFile ( InputStream OS ) {
        Scanner sc = new Scanner(OS);
        while(sc.hasNextLine()) {
            String [] wordNb = sc.nextLine().split(" ");
            resultExpected.put(wordNb[0],Integer.parseInt(wordNb[1]));
        }
    }
}
