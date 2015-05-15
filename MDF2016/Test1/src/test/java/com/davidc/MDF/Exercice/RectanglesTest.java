/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cuvellierdavid
 */
public class RectanglesTest {
    
    public RectanglesTest() {
    }
   
    /**
     * Test of compute method, of class Rectangles.
     */
    @Test
    public void testCompute() throws Exception {
        System.out.println("compute");
        String in = "Rectangles/input1.txt";
        String out = "Rectangles/output1.txt";

        Rectangles instance = new Rectangles();
        boolean expResult = true;
        boolean result = instance.launchCompute(in, out);
        assertEquals(expResult, result);

        in = "Rectangles/input2.txt";
        out = "Rectangles/output2.txt";
        result = instance.launchCompute(in, out);
        assertEquals(expResult, result);

        in = "Rectangles/input3.txt";
        out = "Rectangles/output3.txt";
        result = instance.launchCompute(in, out);
        assertEquals(expResult, result);
    
    
    }
    
}
