/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice.someobject;

/**
 *
 * @author cuvellierdavid
 */
public class detailPerson implements Comparable <Object>{
    public String prenom;
    public String nom;
    public String compagny;
    public String phoneNumber;
    public String pays;
    public detailPerson (){
        this.prenom = "";
        this.nom = "";
        this.compagny = "";
        this.phoneNumber = "";
        this.pays = "";    }
    public detailPerson (String pren,
            String no,
            String compa,
            String phoneN,
            String pay){
        this.prenom = pren;
        this.nom = no;
        this.compagny = compa;
        this.phoneNumber = phoneN;
        this.pays = pay;
    }

    @Override
    public int compareTo(Object o) {
        if (this.nom.compareToIgnoreCase(((detailPerson)o).nom ) < 0){
            return -1;
        }else{
        if (this.nom.compareToIgnoreCase(((detailPerson)o).nom ) > 0){
            return 1;}            
        }
        if (this.prenom.compareToIgnoreCase(((detailPerson)o).prenom ) < 0){
            return -1;
        }else{
        if (this.prenom.compareToIgnoreCase(((detailPerson)o).prenom ) >0){
            return 1;}            
        }        
        if (this.compagny.compareToIgnoreCase(((detailPerson)o).compagny ) < 0){
            return -1;
        }else{
        if (this.compagny.compareToIgnoreCase(((detailPerson)o).compagny ) > 0){
            return 1;}            
        }        
        return 0;
    }
    
    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof detailPerson))
            return false;
        if (obj == this)
            return true;

        detailPerson dp = (detailPerson) obj;
        
        if (dp.nom.compareToIgnoreCase(this.nom) == 0){
            if (dp.prenom.compareToIgnoreCase(this.prenom) == 0){
                if (dp.compagny.compareToIgnoreCase(this.compagny) == 0){
                    return true;
                }
            }            
        }
        return false;
    }
}
