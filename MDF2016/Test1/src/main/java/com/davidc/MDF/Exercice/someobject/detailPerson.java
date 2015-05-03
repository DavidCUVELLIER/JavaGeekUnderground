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
public class detailPerson {
    public String prenom;
    public String nom;
    public String ville;
    public String phoneNumber;
    public String pays;
    
    public detailPerson (String pren,
            String no,
            String vill,
            String phoneN,
            String pay){
        this.prenom = pren;
        this.nom = no;
        this.ville = vill;
        this.phoneNumber = phoneN;
        this.pays = pay;
    }
}
