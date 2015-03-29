/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice;

import com.davidc.MDF.Exercice.someobject.des;
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
public class MonopolyTest {
    
    public MonopolyTest() {
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
     * Test of process method, of class Monopoly.
     */
    @Test
    public void testProcess() throws Exception {
        System.out.println("process");
        String path = "/Users/cuvellierdavid/NetBeansProjects/TestMDF/test/resources/monopoly/";

        Monopoly instance = new Monopoly();

        Boolean result = instance.process(path+"input1.txt", path+"output1.txt");
        assertEquals(true, result);
        result = instance.process(path+"input2.txt", path+"output2.txt");
        assertEquals(true, result);
        result = instance.process(path+"input3.txt", path+"output3.txt");
        assertEquals(true, result);
    }

    /**
     * Test of readInputFile method, of class Monopoly.
     */
    @Test
    public void testReadInputFile() {
        System.out.println("readInputFile");
        InputStream IS = null;
        List<Integer> dues = null;
        List<des> moves = null;
        Monopoly instance = new Monopoly();
        Integer expResult = null;
        Integer result = instance.readInputFile(IS, dues, moves);
 //       assertEquals(expResult, result);
    }
    
}
