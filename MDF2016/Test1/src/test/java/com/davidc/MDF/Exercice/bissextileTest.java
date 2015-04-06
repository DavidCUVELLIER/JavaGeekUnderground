/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice;

import java.io.InputStream;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cuvellierdavid
 */
public class bissextileTest {
    
    public bissextileTest() {
    }

 
    /**
     * Test of isBissextile method, of class bissextile.
     */
    @Test
    public void testIsBissextile() {
        System.out.println("isBissextile");
        Integer a = null;
        bissextile instance = new bissextile();
        Boolean result = instance.isBissextile(2);
        assertEquals(false, result);       
        result = instance.isBissextile(4);
        assertEquals(true, result);
        result = instance.isBissextile(100);
        assertEquals(false, result);
        result = instance.isBissextile(150);
        assertEquals(false, result);
        result = instance.isBissextile(800);
        assertEquals(true, result);
    }

    /**
     * Test of launchCompute method, of class bissextile.
     */
    @Test
    public void testLaunchCompute() throws Exception {
        System.out.println("launchCompute");
        String in = "bissextile/input1.txt";
        String out = "bissextile/output1.txt";
        bissextile instance = new bissextile();
        Boolean expResult = true;
        Boolean result = instance.launchCompute(in, out);
        assertEquals(expResult, result);
        in = "bissextile/input2.txt";
        out = "bissextile/output2.txt";
        result = instance.launchCompute(in, out);
        assertEquals(expResult, result);
    }

}
