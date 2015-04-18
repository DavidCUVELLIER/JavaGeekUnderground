/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice;

import com.davidc.MDF.Exercice.someobject.PokerGainLost;
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
import java.util.Scanner;

/**
 *
 * @author cuvellierdavid
 */
public class Poker {
    Integer inialValue = 0;
    Integer nbTurn = 0;
    List<PokerGainLost> turns = new ArrayList<PokerGainLost>();
    Integer resultExpected =0;
    
       public Boolean launchCompute(String in, String out) throws FileNotFoundException, URISyntaxException{
        InputStream IS,OS;
        URL resourceIN = this.getClass().getClassLoader().getResource(in);
        URL resourceOUT = this.getClass().getClassLoader().getResource(out);
        IS = new FileInputStream(new File(resourceIN.toURI()));
        OS = new FileInputStream(new File(resourceOUT.toURI()));
        return compute(IS, OS);
    }
       
    boolean compute (InputStream IS, InputStream OS){
        List<PokerGainLost> input = readInputFile ( IS );
        readOutputFile(OS);
        Integer result = inialValue;
        for (PokerGainLost turn : turns) {
            result = result - turn.getGain() + turn.getLost();
        }
        return (result.equals(resultExpected) );
    }
    List<PokerGainLost> readInputFile ( InputStream IS ) {
        String line = "";
        String a[];
        List<PokerGainLost> result = new ArrayList<PokerGainLost>();
        Scanner sc = new Scanner(IS);
        inialValue = Integer.parseInt(sc.nextLine());
        nbTurn = Integer.parseInt(sc.nextLine());
        turns.clear();
        while(sc.hasNextLine()) {
            line = sc.nextLine();
            a=line.split(" ");
            PokerGainLost PokerGainLost = new PokerGainLost();
            PokerGainLost.setGain(Integer.parseInt(a[0]));
            PokerGainLost.setLost(Integer.parseInt(a[1]));
            turns.add(PokerGainLost);
        }

        return result;
    }
    
    void readOutputFile ( InputStream OS ) {
        Scanner sc = new Scanner(OS);
        resultExpected = Integer.parseInt(sc.nextLine());
    }
}
