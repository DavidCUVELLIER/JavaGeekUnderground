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
public class OutPutRectangle {
    private Point downLeft;
    private Point topLeft;
    private Point downRight;
    private Point topRight;
    
    public OutPutRectangle (){};
    
    public OutPutRectangle ( Integer xLeft,
            Integer yDown,
            Integer xRight,
            Integer yTop){
        downLeft = new Point(xLeft,yDown);
        topLeft = new Point(xLeft,yTop);
        downRight = new Point(xRight,yDown);
        topRight = new Point(xRight,yTop);
    }
    
    public String toString(){
        String result = downLeft.toString() + " ";
        result = result + topLeft.toString() + " ";
        result = result + downRight.toString() + " ";
        result = result + topRight.toString() + " ";
        return result;
    }
}
