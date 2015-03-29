/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice;

import java.io.InputStream;
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
public class CompressionTest {
    
    public CompressionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of compute method, of class Compression.
     */
    @Test
    public void testCompute() throws Exception {
        //String path = "/Users/cuvellierdavid/NetBeansProjects/TestMDF/test/resources/compression/";

        System.out.println("compute");
        String in = "compression/input1.txt";
        String out = "compression/output1.txt";
        Compression instance = new Compression();
        Boolean expResult = true;
        Boolean result = instance.launchCompute(in, out);
        assertEquals(expResult, result);
        in = "compression/input2.txt";
        out = "compression/output2.txt";
        result = instance.launchCompute(in, out);
        assertEquals(expResult, result);
        
        in = "compression/input3.txt";
        out = "compression/output3.txt";
        result = instance.launchCompute(in, out);
        assertEquals(expResult, result);
    }
    /**
     * Test of compr method, of class Compression.
     */
    @Test
    public void testCompr() {
        System.out.println("compr");
        Compression instance = new Compression();
        String input = "bbddb";
        String expResult = "bbddb";
        String result = instance.compr(input);
        assertEquals(expResult, result);
        input = "cccccfffdd";
        expResult = "5c3fdd";
        result = instance.compr(input);
        assertEquals(expResult, result);
        input = "eeeeeaaaaa";
        expResult = "5e5a";
        result = instance.compr(input);
        assertEquals(expResult, result);
    

    }


    
}
