/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice;

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
public class GolfTest {
    
    public GolfTest() {
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
     * Test of compute method, of class Golf.
     */
    @Test
    public void testCompute() {
        System.out.println("compute");
        int club1 = 6;
        int club2 = 12;
        int club3 = 50;
        int target = 100;
        List<Integer> path = new ArrayList<>();
        Golf instance = new Golf();
        List<Integer> result = instance.compute(club1, club2, club3, target, path);
        assertNotNull(result);

    }
    
}
