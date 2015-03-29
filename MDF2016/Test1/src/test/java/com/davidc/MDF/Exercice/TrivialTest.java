/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
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
public class TrivialTest {
    
    public TrivialTest() {
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
     * Test of computeNextCase method, of class Trivial.
     */
    @Test
    public void testComputeNextCase() {
        System.out.println("computeNextCase");
        int start = 8;
        int laps = 4;
        Trivial instance = new Trivial();
        int result = instance.computeNextCase(8, 4);
        assertEquals(result, 12);
    }

    /**
     * Test of readFile method, of class Trivial.
     */
    @Test
    public void testReadFile() throws FileNotFoundException {
        System.out.println("readFile");
        InputStream IS = new FileInputStream( "/Users/cuvellierdavid/IT/Le_Meilleur_Dev_de_France_2014/problems/1_Trivial-Pursuit/input1.txt");
        Trivial instance = new Trivial();
        List<Integer> expResult = new ArrayList<>();
        expResult.add(4);expResult.add(1);expResult.add(5);
        expResult.add(3);expResult.add(2);expResult.add(2);
        expResult.add(6);expResult.add(2);expResult.add(1);
        List<Integer> result = instance.readInputFile(IS);
        assertEquals(expResult.size(), result.size());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of process method, of class Trivial.
     */
    @Test
    public void testProcess() throws FileNotFoundException {
        System.out.println("process");
        Trivial instance = new Trivial();
        String path = "/Users/cuvellierdavid/NetBeansProjects/TestMDF/test/resources/Trivial/";
        boolean result = instance.process(path + "input1.txt",
                0,path + "output1.txt");
        assertEquals(true, result);
        result = instance.process(path + "input2.txt",
                0,path + "output2.txt");
        assertEquals(true, result);
        result = instance.process(path +"input3.txt",
                0,path + "output3.txt");
        assertEquals(true, result);
     }
    
    @Test
    public void testconvertIntegerToLesSixCouleurs(){
        System.out.println("convertIntegerToLesSixCouleurs");
        Trivial instance = new Trivial();
        Trivial.lesSixCouleurs result = instance.convertIntegerToLesSixCouleurs(5);
        assertEquals(Trivial.lesSixCouleurs.bleu, result);
        result = instance.convertIntegerToLesSixCouleurs(9);
        assertEquals(Trivial.lesSixCouleurs.vert, result);
        result = instance.convertIntegerToLesSixCouleurs(46);
        assertEquals(Trivial.lesSixCouleurs.rose, result);
     }
    
}
