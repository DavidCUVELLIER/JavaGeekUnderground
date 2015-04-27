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
public class NuageTagsTest {
    
    public NuageTagsTest() {
    }

    /**
     * Test of launchCompute method, of class NuageTags.
     */
    @Test
    public void testLaunchCompute() throws Exception {
        System.out.println("launchCompute");
        String in = "nuagetags/input1.txt";
        String out = "nuagetags/output1.txt";
        NuageTags instance = new NuageTags();
        Boolean expResult = true;
        Boolean result = instance.launchCompute(in, out);
        assertEquals(expResult, result);

        in = "nuagetags/input2.txt";
        out = "nuagetags/output2.txt";
        instance = new NuageTags();
        result = instance.launchCompute(in, out);
        assertEquals(expResult, result);
    }

}
