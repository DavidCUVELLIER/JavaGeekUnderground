/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice;

import com.davidc.MDF.Exercice.someobject.InputMatrix;
import com.davidc.MDF.Exercice.someobject.LineMatrix;
import com.davidc.MDF.Exercice.someobject.OutPutMatrix;
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
public class Matrix {
    public boolean launchCompute (String in,String out) throws FileNotFoundException, URISyntaxException{
          InputStream IS,OS;
        URL resourceIN = this.getClass().getClassLoader().getResource(in);
        URL resourceOUT = this.getClass().getClassLoader().getResource(out);
        IS = new FileInputStream(new File(resourceIN.toURI()));
        OS = new FileInputStream(new File(resourceOUT.toURI()));
        return compute(IS, OS);      
    }
    
    public boolean compute(InputStream IS, InputStream OS) throws FileNotFoundException{
 
        InputMatrix inputMatrix = readInputFile(IS);
        OutPutMatrix outputMatrix = readOutputFile(OS);
        inputMatrix.generate();
        return (outputMatrix.toString().compareToIgnoreCase(inputMatrix.getOutPutMatrix().toString()) == 0);

    }
    
    InputMatrix readInputFile ( InputStream IS ) {
        InputMatrix result = new InputMatrix();
        Boolean isFirstLine = true;
        try{
            BufferedReader buff = new BufferedReader(new InputStreamReader(IS, "UTF-8"));
            try {
                String line ="";
                List<LineMatrix> lineMaxtrixs = new ArrayList<LineMatrix>();
                int currentRaw = 0;
                int currentCol = 0;
                int maxRaw = 0;
                int maxCol = 0;
                int minRaw = 0;
                int minCol = 0;
                while ((line = buff.readLine()) != null) {
                    LineMatrix lineMatrix = new LineMatrix();
                    if (isFirstLine){
                        result.setSizeMatrix(Integer.parseInt(line));
                        if (result.getSizeMatrix() == 4){
                            minRaw = 2;
                            maxRaw = 3;
                            minCol = 1;
                            maxCol = 2;
                            }
                        if (result.getSizeMatrix() == 8){
                            minRaw = 3;
                            maxRaw = 6;
                            minCol = 2;
                            maxCol = 5;
                            }
                        isFirstLine = false;
                    }else{
                        if ((currentRaw >= minRaw) && 
                                (currentRaw <= maxRaw)){
                            String[] coordonnees = line.split(" ");
                            List<Integer> elets = new ArrayList<Integer>();
                            currentCol = 0;
                            for ( String val : coordonnees){
                                if ((currentCol >= minCol) &&
                                        (currentCol <= maxCol)){
                                    elets.add(Integer.parseInt(val));
                                }
                                currentCol ++;
                            }
                            lineMatrix = new LineMatrix(elets);
                            lineMaxtrixs.add(lineMatrix);
                        }
                    }
                    currentRaw ++;
                }
                result.setLineMaxtrixs(lineMaxtrixs);
            } finally {
                buff.close();
            }
        } catch (Exception ioe) {
            System.out.println("Erreur --" + ioe.toString());
        }
        return result;
    }

    OutPutMatrix readOutputFile ( InputStream OS ) {
        OutPutMatrix result = null;
        try{
            BufferedReader buff = new BufferedReader(new InputStreamReader(OS, "UTF-8"));
            try {
                String line ="";
                while ((line = buff.readLine()) != null) {
                    String[] coordonnees = line.split(" ");
                    result = new OutPutMatrix(Integer.parseInt(coordonnees[0]), 
                            Integer.parseInt(coordonnees[1]), 
                            Double.parseDouble(coordonnees[2]), 
                            Integer.parseInt(coordonnees[3]));
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
