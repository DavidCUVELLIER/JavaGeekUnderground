/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice;

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
public class MatrixTest {
    
    public MatrixTest() {
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
     * Test of compute method, of class Matrix.
     */
    @Test
    public void testCompute() throws Exception {
        String path = "/Users/cuvellierdavid/NetBeansProjects/TestMDF/test/resources/matrix/";
        System.out.println("compute");
        String in = path+"input1.txt";
        String out = path+"output1.txt";
         Matrix instance = new Matrix();
        boolean expResult = true;
        boolean result = instance.compute(in, out);
        assertEquals(expResult, result);

        in = path+"input2.txt";
        out = path+"output2.txt";

   //     result = instance.compute(in, out);
        assertEquals(expResult, result);

    }


}
