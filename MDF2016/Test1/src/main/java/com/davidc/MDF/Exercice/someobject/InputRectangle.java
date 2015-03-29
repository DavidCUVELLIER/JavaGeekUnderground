/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice.someobject;


import java.util.List;

/**
 *
 * @author cuvellierdavid
 */
public class InputRectangle {
    private Integer nbRectangles = 0;
    private List<Rectangle> rectangles ;

    /**
     * @return the nbRectangles
     */
    public Integer getNbRectangles() {
        return nbRectangles;
    }

    /**
     * @param nbRectangles the nbRectangles to set
     */
    public void setNbRectangles(Integer nbRectangles) {
        this.nbRectangles = nbRectangles;
    }

    /**
     * @return the rectangles
     */
    public List<Rectangle> getRectangles() {
        return rectangles;
    }

    /**
     * @param rectangles the rectangles to set
     */
    public void setRectangles(List<Rectangle> rectangles) {
        this.rectangles = rectangles;
    }
}
