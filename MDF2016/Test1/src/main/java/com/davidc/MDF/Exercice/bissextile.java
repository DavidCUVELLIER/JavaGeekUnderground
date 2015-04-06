/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author cuvellierdavid
 */
enum BissextileOuNon{
    BISSEXTILE,
    NON_BISSEXTILE
}

public class bissextile {
    int nbElement = 0;
    List<Integer> lAnnee = new ArrayList<Integer>();
    Map<Integer,BissextileOuNon> bissextileOuNons = new HashMap<Integer,BissextileOuNon>();
    
    public Boolean launchCompute(String in, String out) throws FileNotFoundException, URISyntaxException{
        InputStream IS,OS;
        URL resourceIN = this.getClass().getClassLoader().getResource(in);
        URL resourceOUT = this.getClass().getClassLoader().getResource(out);
        IS = new FileInputStream(new File(resourceIN.toURI()));
        OS = new FileInputStream(new File(resourceOUT.toURI()));
        Map<Integer,BissextileOuNon> bissextileOuNons = compute(IS);
        Map<Integer,BissextileOuNon> output= readOutputFile ( OS );
        for (Map.Entry<Integer, BissextileOuNon> entry : output.entrySet()) {
            BissextileOuNon value = bissextileOuNons.get(entry.getKey());
            if (value.compareTo(entry.getValue() )!= 0) {
                return false;
            }
        }
        return true;
    }
    
    public Map<Integer,BissextileOuNon> compute(InputStream IS) throws FileNotFoundException, URISyntaxException{
        List<Integer> input = readInputFile ( IS );
        Map<Integer,BissextileOuNon> result = new HashMap<>();
        Integer cpt = 1;
        for (Integer value : input ){
            if (isBissextile(value)){
                result.put(cpt,BissextileOuNon.BISSEXTILE);
            }else{
                result.put(cpt,BissextileOuNon.NON_BISSEXTILE);
            }
            ++cpt;
        }
        
        return result;
    }
    public Boolean isBissextile(Integer a){
        if ((a % 4 == 0 ) && (a % 100 != 0)){
            return true;
        }
        if (a % 400 == 0 ){
            return true;
        }
        return false;
    }
    
    List<Integer> readInputFile ( InputStream IS ) {
        List<Integer> result = new ArrayList<Integer>();
        try{
            BufferedReader buff = new BufferedReader(new InputStreamReader(IS, "UTF-8"));
            try {
                String line ="";
                boolean isFirstLine = true;
                while ((line = buff.readLine()) != null) {
                    if (isFirstLine){
                        nbElement = Integer.parseInt(line);
                        isFirstLine = false;
                    }else{
                        result.add(Integer.parseInt(line));
                    }
                }
            } finally {
                buff.close();
            }
        } catch (Exception ioe) {
            System.out.println("Erreur --" + ioe.toString());
        }
        return result;
    }

       Map<Integer,BissextileOuNon> readOutputFile ( InputStream OS ) {
        Map<Integer,BissextileOuNon> result = new HashMap<>();
        try{
            BufferedReader buff = new BufferedReader(new InputStreamReader(OS, "UTF-8"));
            try {
                String line ="";
                Integer cpt = 1;
                while ((line = buff.readLine()) != null) {    
                    line = line.replace(' ', '_');
                    result.put(cpt,BissextileOuNon.valueOf(line));
                    ++cpt;
                }
            } finally {
                buff.close();
            }
        } catch (Exception ioe) {
            System.out.println("Erreur --" + ioe.toString());
        }
        return result;
    }
}
