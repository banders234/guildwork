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
public class Fix23Test {
    
    public Fix23Test() {
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
    public void Fix23Test1() {
        Fix23 f23 = new Fix23();
        int[] original = {1,2,3};
        int[] result = f23.fix23(original);
        int[] test= {1,2,0};
        Assert.assertArrayEquals(test, result);
    }
    public void Fix23Test2() {
        Fix23 f23 = new Fix23();
        int[] original = {2,3,5};
        int[] result = f23.fix23(original);
        int[] test= {2,0,5};
        Assert.assertArrayEquals(test, result);
    }
    public void Fix23Test3() {
        Fix23 f23 = new Fix23();
        int[] original = {1,2,1};
        int[] result = f23.fix23(original);
        int[] test= {1,2,1};
        Assert.assertArrayEquals(test, result);
    }
}
