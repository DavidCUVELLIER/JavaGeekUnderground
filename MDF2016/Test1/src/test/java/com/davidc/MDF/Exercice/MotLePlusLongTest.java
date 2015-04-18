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
public class MotLePlusLongTest {
    
    public MotLePlusLongTest() {
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
     * Test of compute method, of class MotLePlusLong.
     */
    @Test
    public void testCompute() throws Exception {
        System.out.println("compute");
        String in = "MotLePlusLong/input1.txt";
        String out = "MotLePlusLong/output1.txt";
        MotLePlusLong instance = new MotLePlusLong();
        int expResult = 0;
        int result = instance.launchCompute(in, out);
        assertEquals(expResult, result);

        in = "MotLePlusLong/input2.txt";
        out = "MotLePlusLong/output2.txt";
        result = instance.launchCompute(in, out);
        assertEquals(expResult, result);

        in = "MotLePlusLong/input3.txt";
        out = "MotLePlusLong/output3.txt";
        result = instance.launchCompute(in, out);
        assertEquals(expResult, result);
    
    }
    
}
