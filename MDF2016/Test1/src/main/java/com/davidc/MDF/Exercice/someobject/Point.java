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
public class Point {
    private Integer x;
    private Integer y;

    public Point(Integer x1, Integer y1){
        x = x1;
        y = y1;
    }
    
    public String toString(){
        return x.toString() + " " + y.toString();
    }
    /**
     * @return the x
     */
    public Integer getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(Integer x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public Integer getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(Integer y) {
        this.y = y;
    }
}
