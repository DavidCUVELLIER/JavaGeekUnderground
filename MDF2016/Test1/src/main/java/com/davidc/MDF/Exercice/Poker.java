/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice;

import com.davidc.MDF.Exercice.someobject.PokerGainLost;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    List<PokerGainLost> turn = new ArrayList<PokerGainLost>();

    List<PokerGainLost> readInputFile ( InputStream IS ) {
        List<PokerGainLost> result = new ArrayList<PokerGainLost>();
        Scanner sc = new Scanner(IS);
        inialValue = Integer.parseInt(sc.nextLine());
        nbTurn = Integer.parseInt(sc.nextLine());
        while(sc.hasNextLine()) {

        }

        return result;
    }
}
