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
import java.util.List;

/**
 *
 * @author cuvellierdavid
 */
public class Compression {
    
    public Boolean launchCompute(String in, String out) throws FileNotFoundException, URISyntaxException{
        InputStream IS,OS;
        URL resourceIN = this.getClass().getClassLoader().getResource(in);
        URL resourceOUT = this.getClass().getClassLoader().getResource(out);
        IS = new FileInputStream(new File(resourceIN.toURI()));
        OS = new FileInputStream(new File(resourceOUT.toURI()));
        return compute(IS, OS);
    }
    
    public Boolean compute(InputStream IS, InputStream OS) throws FileNotFoundException, URISyntaxException{

        String input = readInputFile ( IS );
        String output = readInputFile ( OS );
        String compressed = compr(input);
        return (compressed.compareToIgnoreCase(output)==0);
    }
    
    String compr( String input){
        String result = "";
        int cptOccur = 0;
        char prevChar = '\n';
        boolean isFirst = true;
        Integer cptPos = 0;
        for(char a : input.toCharArray()){
            if (isFirst) {
                cptOccur ++;
            }else {
                if ((a == prevChar)){
                    cptOccur ++;
                }else{
                    result = concatenateResult( cptOccur,prevChar, result);
                    cptOccur = 1;
                }
                if ( cptPos == (input.length()-1)){
                    result = concatenateResult( cptOccur,a, result);
                }
            }
            cptPos ++;
            prevChar=a;
            isFirst = false;
        }
        return result;
    }
    
    String concatenateResult(Integer cptOccur,
            char prevChar,String input){
        if (cptOccur == 1){
            input = input + prevChar;
        }
        if (cptOccur == 2){
            input = input + prevChar +prevChar;
        }
        if (cptOccur >2 ){
            input = input + String.valueOf(cptOccur)+prevChar;
        }
        return input;
    }
    String readInputFile ( InputStream IS ) {
        String result = "";
        try{
            BufferedReader buff = new BufferedReader(new InputStreamReader(IS, "UTF-8"));
            try {
                String line ="";
                while ((line = buff.readLine()) != null) {
                    result = line;
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
