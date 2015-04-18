/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidc.MDF.Exercice;

import com.davidc.MDF.Exercice.someobject.PokerGainLost;
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
public class PokerTest {
    

    /**
     * Test of launchCompute method, of class Poker.
     */
    @Test
    public void testLaunchCompute() throws Exception {
        Poker instance = new Poker();
        Boolean expResult = true;
        System.out.println("launchCompute");
        String in = "poker/input1.txt";
        String out = "poker/output1.txt";
        Boolean result = instance.launchCompute(in, out);
        assertEquals(expResult, result);

        in = "poker/input2.txt";
        out = "poker/output2.txt";
        result = instance.launchCompute(in, out);
        assertEquals(expResult, result);

    }


}
