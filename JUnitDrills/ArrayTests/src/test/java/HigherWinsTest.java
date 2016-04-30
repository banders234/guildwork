/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class HigherWinsTest {
    
    public HigherWinsTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void higherWinsTest1() {
        HigherWins hw = new HigherWins();
        int[] original = {1,2,3};
        int[] result = hw.higherWins(original);
        int[] test = {3,3,3};
        Assert.assertArrayEquals(test, result);
    }
    @Test
    public void higherWinsTest2() {
        HigherWins hw = new HigherWins();
        int[] original = {11,5,9};
        int[] result = hw.higherWins(original);
        int[] test = {11,11,11};
        Assert.assertArrayEquals(test, result);
    }
    @Test
    public void higherWinsTest3() {
        HigherWins hw = new HigherWins();
        int[] original = {2,11,3};
        int[] result = hw.higherWins(original);
        int[] test = {3,3,3};
        Assert.assertArrayEquals(test, result);
    }
}
