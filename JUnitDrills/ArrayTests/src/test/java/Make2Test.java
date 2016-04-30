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
public class Make2Test {
    
    public Make2Test() {
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
    public void Make2Test1() {
        Make2 m2 = new Make2();
        int[] original1= {4,5};
        int[] original2 = {1,2,3};
        int[] result = m2.make2(original1, original2);
        int[] test = {4,5};
        Assert.assertArrayEquals(test, result);
    }
    @Test
    public void Make2Test2() {
        Make2 m2 = new Make2();
        int[] original1= {4};
        int[] original2 = {1,2,3};
        int[] result = m2.make2(original1, original2);
        int[] test = {4,1};
        Assert.assertArrayEquals(test, result);
    }
    @Test
    public void Make2Test3() {
        Make2 m2 = new Make2();
        int[] original1= {};
        int[] original2 = {1,2};
        int[] result = m2.make2(original1, original2);
        int[] test = {1,2};
        Assert.assertArrayEquals(test, result);
    }
}
