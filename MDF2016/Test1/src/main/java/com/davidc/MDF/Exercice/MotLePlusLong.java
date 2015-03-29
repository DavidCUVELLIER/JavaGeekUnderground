/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice;

import com.davidc.MDF.Exercice.someobject.TextInput;
import com.davidc.MDF.Exercice.someobject.TextOutput;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author cuvellierdavid
 */
public class MotLePlusLong {
    
        public int launchCompute(String in, String out) throws FileNotFoundException, URISyntaxException{
        InputStream IS,OS;
        URL resourceIN = this.getClass().getClassLoader().getResource(in);
        URL resourceOUT = this.getClass().getClassLoader().getResource(out);
        IS = new FileInputStream(new File(resourceIN.toURI()));
        OS = new FileInputStream(new File(resourceOUT.toURI()));
        return compute(IS, OS);
    }
    public int compute(InputStream IS, InputStream OS) throws FileNotFoundException{

        TextInput textInput = readInputFile(IS);
        TextOutput textOutput = readOutputFile(OS);
        textInput.generate();
        textInput.clean();
        return textOutput.compareTo((textInput.getTextOutput()));
    }
    
    String removeACharInaString(String line, String letter){
        String[] lineSplitted = line.split(letter);
        if (lineSplitted != null){
            if (lineSplitted.length >= 2){
               line = "";
               for(String lineWord : lineSplitted){
                   line = line.concat(lineWord);
               }
            }
        }
        return line;
    }
    TextInput readInputFile ( InputStream IS ) {
        TextInput result = new TextInput();
        try{
            BufferedReader buff = new BufferedReader(new InputStreamReader(IS, "UTF-8"));
            try {
                String line ="";
                while ((line = buff.readLine()) != null) {
                    line = line.substring(0, line.length()-1);
                    line = line.replace('\'',' ');
                    line = line.replace('.',',');
                    line = removeACharInaString(line, ",");
                    line = line.toLowerCase();
                    result.addLine(line);
                }
            } finally {
                buff.close();
            }
        } catch (Exception ioe) {
            System.out.println("Erreur --" + ioe.toString());
        }
        return result;
    }

    TextOutput readOutputFile ( InputStream OS ) {
        TextOutput result = new TextOutput();
        try{
            BufferedReader buff = new BufferedReader(new InputStreamReader(OS, "UTF-8"));
            try {
                String line ="";
                while ((line = buff.readLine()) != null) {
                    String[] WordOccuArray = line.split(" ");
                    result.addMotOcurrence(WordOccuArray[1],
                            Integer.parseInt(WordOccuArray[0]));
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
