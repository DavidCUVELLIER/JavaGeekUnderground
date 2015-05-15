/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice;

import com.davidc.MDF.Exercice.someobject.SalesForceOutput;
import com.davidc.MDF.Exercice.someobject.detailPerson;
import com.davidc.MDF.Exercice.someobject.ResultDetailPerson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author cuvellierdavid
 */
public class SalesForce {
    List<String> listPays = new ArrayList<>();
    List<detailPerson> listPersons = new ArrayList<>();
    SalesForceOutput SFOComputed ;
    SalesForceOutput SFOExpected ;
    
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

        ResultDetailPerson resultDetailPerson= verifyNBDoublonsAndBadPhone();

        int Z = verifyNBOutOfZone();
        
        SFOComputed =  new SalesForceOutput(resultDetailPerson.nbDoublons,
                resultDetailPerson.nbBadTel,Z);
        if (SFOComputed.compareTo(SFOExpected) == 0){
            return true;
        }  
        return false;
    }
    
    ResultDetailPerson verifyNBDoublonsAndBadPhone(){
        ResultDetailPerson resultDetailPerson = new ResultDetailPerson();

        listPersons.sort(null);
        detailPerson personTemp = new detailPerson();
        detailPerson personTemp2 = new detailPerson();
        for (detailPerson person : listPersons) { 
            if (personTemp2.equals(personTemp)){
            }else{
                if (personTemp.equals(person)){
                   ++resultDetailPerson.nbDoublons; 
                }else{
                    boolean isCorrectNumber = true;
                     if (person.phoneNumber.matches("[+]\\d{1,3}[-]\\d{9,11}") == false){
                        ++resultDetailPerson.nbBadTel; 
                     }
                }               
            }
            personTemp2 = personTemp;
            personTemp = person;
        }
        return resultDetailPerson;
    }
        

    int verifyNBOutOfZone(){
        int result = 0;
        for (detailPerson person : listPersons) {
            if (listPays.contains(person.pays) == false ){
                ++result;
            }
        }
        return result;
    }
    
    void readInputFile(InputStream IS ){
        Scanner sc = new Scanner(IS);
        int nbPersons = Integer.parseInt(sc.nextLine());
        String pays = sc.nextLine();
        listPays.clear();
        listPays = Arrays.asList(pays.split(";"));
        listPersons.clear();
        while(sc.hasNextLine()) {
            String[] line = sc.nextLine().split(";");
            listPersons.add(new detailPerson(line[0], line[1], line[2], line[3], line[4]));
        }
    }
    
    void readOutputFile(InputStream OS ){
        Scanner sc = new Scanner(OS);
        String[] res = sc.nextLine().split(" ");
        SFOExpected =  new SalesForceOutput(Integer.parseInt(res[0]), 
                Integer.parseInt(res[1]), 
                Integer.parseInt(res[2]));
    }
}
