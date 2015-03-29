/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice;

import org.junit.*;

/**
 *
 * @author cuvellierdavid
 */
public class AnagrammeTest {
    
    public AnagrammeTest() {
    }
    

    /**
     * Test of compute method, of class Anagramme.
     */
    @Test
    public void testCompute() {
        System.out.println("compute");
        Anagramme instance = new Anagramme();
        int result = instance.compute();
        Assert.assertNotSame(-1, result);

    }
    
}
