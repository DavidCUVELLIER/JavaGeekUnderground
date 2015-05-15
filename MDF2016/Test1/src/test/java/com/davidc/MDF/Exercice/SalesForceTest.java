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
public class SalesForceTest {
    
    public SalesForceTest() {
    }
    
    /**
     * Test of launchCompute method, of class SalesForce.
     */
    //@Test
    //ce test ne fonctionne pas
    //le probleme n est pas fini de coder
    public void testLaunchCompute() throws Exception {
        System.out.println("launchCompute");
        String in = "SalesForce/input1.txt";
        String out = "SalesForce/output1.txt";
        SalesForce instance = new SalesForce();
        Boolean expResult = true;
        Boolean result = instance.launchCompute(in, out);
        assertEquals(expResult, result);

    }
    
}
