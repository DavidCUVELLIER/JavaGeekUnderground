/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice;

import com.davidc.MDF.Exercice.someobject.des;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuvellierdavid
 */

public class Monopoly {
    Boolean process(String in, String out) throws FileNotFoundException{
        InputStream IS,OS;
        IS = new FileInputStream(in);
        OS = new FileInputStream(out);
        List<Integer> dues = new ArrayList<>();
        List<des> moves = new ArrayList<>();
        
        Integer inputMoney = readInputFile ( IS,dues,moves );
        Integer lastPositionExpected = readOutputFile ( OS );
        
        Integer result = monopCompute(inputMoney, dues,moves);
        return (result==lastPositionExpected);
    }
    
    Integer monopCompute(Integer inputMoney,
            List<Integer> dues,
            List<des> moves){
        Integer result = -1;
        Integer position = 1;
        Integer argent = inputMoney;
        for(des de : moves){
            position = position + de.getDes1() + de.getDes2();
            if (position >= 40) { position = position - 40 ;}
            if (position == 20) { position = 10;}
            argent = argent - dues.get(position-1);
            if (argent <= 0) {return position; }
        }
        return position;
    }
    
    Integer readInputFile ( InputStream IS,
            List<Integer> dues,
            List<des> moves) {
        Integer result = -1;
        try{
            BufferedReader buff = new BufferedReader(new InputStreamReader(IS, "UTF-8"));
            try {
                String line;
                int i = 0;
                while ((line = buff.readLine()) != null) {
                    if (i==0) {result = Integer.parseInt(line);}
                    if (i==1) {
                        String duesArray[] = line.split(" ");
                        for(String s : duesArray){
                            dues.add(Integer.parseInt(s));
                        }
                    }
                    if (i==2) {
                        String movesArray[] = line.split(" ");
                        for (int j=0; (j+1) < movesArray.length ; j = j +2){
                            des de = new des(Integer.parseInt(movesArray[j]),
                                    Integer.parseInt(movesArray[j+1]));
                            moves.add(de);
                        }
                    }
                    i++;
                }
            } finally {
                buff.close();
            }
        } catch (Exception ioe) {
            System.out.println("Erreur --" + ioe.toString());
        }
        return result;
    }
    
    Integer readOutputFile ( InputStream OS ) {
        Integer result = -1;
        try{
            BufferedReader buff = new BufferedReader(new InputStreamReader(OS, "UTF-8"));
            try {
                String line;
                while ((line = buff.readLine()) != null) {
                    result = Integer.parseInt(line);
                }
            } finally {
                buff.close();
            }
        } catch (IOException ioe) {
            System.out.println("Erreur --" + ioe.toString());
        }
        return result;
    }

}
