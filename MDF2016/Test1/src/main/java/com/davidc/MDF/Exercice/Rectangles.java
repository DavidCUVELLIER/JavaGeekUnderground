/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice;

import com.davidc.MDF.Exercice.someobject.InputRectangle;
import com.davidc.MDF.Exercice.someobject.OutPutRectangle;
import com.davidc.MDF.Exercice.someobject.Point;
import com.davidc.MDF.Exercice.someobject.Rectangle;
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

/**
 *
 * @author cuvellierdavid
 */
public class Rectangles {
        public Boolean launchCompute(String in, String out) throws FileNotFoundException, URISyntaxException{
        InputStream IS,OS;
        URL resourceIN = this.getClass().getClassLoader().getResource(in);
        URL resourceOUT = this.getClass().getClassLoader().getResource(out);
        IS = new FileInputStream(new File(resourceIN.toURI()));
        OS = new FileInputStream(new File(resourceOUT.toURI()));
        return compute(IS, OS);
    }
        
    public boolean compute(InputStream IS, InputStream OS) throws FileNotFoundException{
 
        InputRectangle inputRectangle = readInputFile(IS);
        OutPutRectangle outputRectangle = readOutputFile(OS);
        OutPutRectangle result = process(inputRectangle);
        return (outputRectangle.toString().compareTo(result.toString()) == 0);
    }
    
    public OutPutRectangle process(InputRectangle IR){
        Integer xLeft = Integer.MAX_VALUE;
        Integer yDown = Integer.MAX_VALUE;
        Integer xRight = Integer.MIN_VALUE;
        Integer yTop = Integer.MIN_VALUE;
        for(Rectangle rectangle : IR.getRectangles()){
            if (rectangle.getPtDownLeft().getX() < xLeft) {xLeft = rectangle.getPtDownLeft().getX();}
            if (rectangle.getPtDownLeft().getY() < yDown) {yDown = rectangle.getPtDownLeft().getY();}
            if (rectangle.getPtTopRight().getX() > xRight) {xRight = rectangle.getPtTopRight().getX();}
            if (rectangle.getPtTopRight().getY() > yTop) {yTop = rectangle.getPtTopRight().getY();}

            if (rectangle.getPtTopRight().getX() < xLeft) {xLeft = rectangle.getPtTopRight().getX();}
            if (rectangle.getPtTopRight().getY() < yDown) {yDown = rectangle.getPtTopRight().getY();}
            if (rectangle.getPtDownLeft().getX() > xRight) {xRight = rectangle.getPtDownLeft().getX();}
            if (rectangle.getPtDownLeft().getY() > yTop) {yTop = rectangle.getPtDownLeft().getY();}
        
        }
        return new OutPutRectangle(xLeft,yDown,xRight,yTop);
    }
    
    InputRectangle readInputFile ( InputStream IS ) {
        InputRectangle result = new InputRectangle();
        Boolean isFirstLine = true;
        try{
            BufferedReader buff = new BufferedReader(new InputStreamReader(IS, "UTF-8"));
            try {
                String line ="";
                List<Rectangle> rectangles = new ArrayList<Rectangle>();
                while ((line = buff.readLine()) != null) {
                    if (isFirstLine){
                        result.setNbRectangles(Integer.parseInt(line));
                        isFirstLine = false;
                    }else{
                        String[] coordonnees = line.split(" ");
                        Point dwnLeft = new Point(Integer.parseInt(coordonnees[0]),
                                Integer.parseInt(coordonnees[1]));
                        Point topRight = new Point(Integer.parseInt(coordonnees[2]),
                                Integer.parseInt(coordonnees[3]));
                        Rectangle rectangle = new Rectangle(dwnLeft,topRight);
                        rectangles.add(rectangle);
                    }

                }
                result.setRectangles(rectangles);
            } finally {
                buff.close();
            }
        } catch (Exception ioe) {
            System.out.println("Erreur --" + ioe.toString());
        }
        return result;
    }

    OutPutRectangle readOutputFile ( InputStream OS ) {
        OutPutRectangle result = new OutPutRectangle();
        try{
            BufferedReader buff = new BufferedReader(new InputStreamReader(OS, "UTF-8"));
            try {
                String line ="";
                while ((line = buff.readLine()) != null) {
                    String[] coordonnees = line.split(" ");
                    result = new OutPutRectangle(Integer.parseInt(coordonnees[0]), 
                            Integer.parseInt(coordonnees[1]), 
                            Integer.parseInt(coordonnees[4]), 
                            Integer.parseInt(coordonnees[3]));
                    }
            } finally {
                buff.close();
            }
        } catch (Exception ioe) {
            System.out.println("Erreur --" + ioe.toString());
        }
        return result;
    }
}
