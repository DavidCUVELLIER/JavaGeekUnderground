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
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuvellierdavid
 */
public class Trivial {
    enum lesSixCouleurs{
        violet ,
        orange,
        jaune,
        vert,
        rose,
        bleu
    }
    
    int computeNextCase(int start, int laps){
        int result = 0;
        result = start + laps;
        if (result > 48) { result = (result - 48) ; } ;
        return result;
    }
    
    List<Integer> readInputFile ( InputStream IS ) {
        List<Integer> result = new ArrayList<Integer>();
        try{
            BufferedReader buff = new BufferedReader(new InputStreamReader(IS, "UTF-8"));
            try {
                String line;
                while ((line = buff.readLine()) != null) {
                    result.add(Integer.parseInt(line));
                }
            } finally {
                buff.close();
            }
        } catch (Exception ioe) {
            System.out.println("Erreur --" + ioe.toString());
        }
        return result;
    }
    
       lesSixCouleurs readOutputFile ( InputStream IS ) {
        lesSixCouleurs result = lesSixCouleurs.bleu;
        try{
            BufferedReader buff = new BufferedReader(new InputStreamReader(IS, "UTF-8"));
            try {
                String line;
                while ((line = buff.readLine()) != null) {
                    result = lesSixCouleurs.valueOf(line);
                }
            } finally {
                buff.close();
            }
        } catch (IOException ioe) {
            System.out.println("Erreur --" + ioe.toString());
        }
        return result;
    }
       
    Boolean process(String in,Integer cursor, String out) throws FileNotFoundException, URISyntaxException{
        InputStream IS,OS;
        URL resourceIN = this.getClass().getClassLoader().getResource(in);
        URL resourceOUT = this.getClass().getClassLoader().getResource(out);
        IS = new FileInputStream(new File(resourceIN.toURI()));
        OS = new FileInputStream(new File(resourceOUT.toURI()));
        List<Integer> input = readInputFile(IS);
        Trivial.lesSixCouleurs result = readOutputFile(OS);
        for( Integer laps : input){
            cursor = computeNextCase(cursor, laps);
        }
        lesSixCouleurs lsc = convertIntegerToLesSixCouleurs(cursor);
        return (lsc == result);
    }
    
    lesSixCouleurs convertIntegerToLesSixCouleurs( Integer i){
        if (i == 1) return lesSixCouleurs.orange;
        if (i == 2) return lesSixCouleurs.jaune;
        if (i == 3) return lesSixCouleurs.vert;
        if (i == 4) return lesSixCouleurs.rose;
        if (i == 5) return lesSixCouleurs.bleu;
        if (i == 6) return lesSixCouleurs.violet;
        if (i == 7) return lesSixCouleurs.orange;
        if (i == 8) return lesSixCouleurs.jaune;
        if (i == 9) return lesSixCouleurs.vert;
        if (i == 10) return lesSixCouleurs.rose;
        if (i == 11) return lesSixCouleurs.bleu;
        if (i == 12) return lesSixCouleurs.violet;
        if (i == 13) return lesSixCouleurs.orange;
        if (i == 14) return lesSixCouleurs.jaune;
        if (i == 15) return lesSixCouleurs.vert;
        if (i == 16) return lesSixCouleurs.rose;
        if (i == 17) return lesSixCouleurs.bleu;
        if (i == 18) return lesSixCouleurs.violet;
        if (i == 19) return lesSixCouleurs.orange;
        if (i == 20) return lesSixCouleurs.jaune;
        if (i == 21) return lesSixCouleurs.vert;
        if (i == 22) return lesSixCouleurs.rose;
        if (i == 23) return lesSixCouleurs.bleu;
        if (i == 24) return lesSixCouleurs.violet;
        if (i == 25) return lesSixCouleurs.orange;
        if (i == 26) return lesSixCouleurs.jaune;
        if (i == 27) return lesSixCouleurs.vert;
        if (i == 28) return lesSixCouleurs.rose;
        if (i == 29) return lesSixCouleurs.bleu;
        if (i == 30) return lesSixCouleurs.violet;
        if (i == 31) return lesSixCouleurs.orange;
        if (i == 32) return lesSixCouleurs.jaune;
        if (i == 33) return lesSixCouleurs.vert;
        if (i == 34) return lesSixCouleurs.rose;
        if (i == 35) return lesSixCouleurs.bleu;
        if (i == 36) return lesSixCouleurs.violet;
        if (i == 37) return lesSixCouleurs.orange;
        if (i == 38) return lesSixCouleurs.jaune;
        if (i == 39) return lesSixCouleurs.vert;
        if (i == 40) return lesSixCouleurs.rose;
        if (i == 41) return lesSixCouleurs.bleu;
        if (i == 42) return lesSixCouleurs.violet;
        if (i == 43) return lesSixCouleurs.orange;
        if (i == 44) return lesSixCouleurs.jaune;
        if (i == 45) return lesSixCouleurs.vert;
        if (i == 46) return lesSixCouleurs.rose;
        if (i == 47) return lesSixCouleurs.bleu;
        return lesSixCouleurs.violet;
    }
}
