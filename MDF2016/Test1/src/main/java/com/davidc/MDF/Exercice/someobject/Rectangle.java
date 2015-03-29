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
public class Rectangle {
    private Point ptDownLeft;
    private Point ptTopRight;

    public Rectangle (Point ptDownLeft1,
            Point ptTopRight1){
        ptDownLeft = ptDownLeft1;
        ptTopRight = ptTopRight1;
    }
    /**
     * @return the ptDownLeft
     */
    public Point getPtDownLeft() {
        return ptDownLeft;
    }

    /**
     * @param ptDownLeft the ptDownLeft to set
     */
    public void setPtDownLeft(Point ptDownLeft) {
        this.ptDownLeft = ptDownLeft;
    }

    /**
     * @return the ptTopRight
     */
    public Point getPtTopRight() {
        return ptTopRight;
    }

    /**
     * @param ptTopRight the ptTopRight to set
     */
    public void setPtTopRight(Point ptTopRight) {
        this.ptTopRight = ptTopRight;
    }
}
