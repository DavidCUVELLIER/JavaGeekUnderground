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
public class SalesForceOutput implements Comparable<Object>{
    int nbDoublons = 0;
    int nbTelephons = 0;
    int nbPersonOutOfZone = 0;
    public SalesForceOutput( int nbd,
            int nbT,
            int nbP){
        this.nbDoublons = nbd;
        this.nbTelephons = nbT;
        this.nbPersonOutOfZone = nbP;
    }

    @Override
    public int compareTo(Object o) {
        if (this.nbDoublons != ((SalesForceOutput)o).nbDoublons ){
            return -1;
        }
        if (this.nbPersonOutOfZone != ((SalesForceOutput)o).nbPersonOutOfZone ){
            return -1;
        }
        if (this.nbTelephons != ((SalesForceOutput)o).nbTelephons ){
            return -1;
        }
        return 0;
    }
}
