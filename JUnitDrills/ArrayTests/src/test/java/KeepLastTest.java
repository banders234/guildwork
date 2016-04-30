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
public class KeepLastTest {
    
    public KeepLastTest() {
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
    public void KeepLast1() {
        KeepLast kl = new KeepLast();
        int[] original = {4,5,6};
        int[] result = kl.keepLast(original);
        int[] test= {0,0,0,0,0,6};
        Assert.assertArrayEquals(test, result);
    }
    public void KeepLast2() {
        KeepLast kl = new KeepLast();
        int[] original = {1,2};
        int[] result = kl.keepLast(original);
        int[] test= {0,0,0,2};
        Assert.assertArrayEquals(test, result);
    }
    public void KeepLast3() {
        KeepLast kl = new KeepLast();
        int[] original = {3};
        int[] result = kl.keepLast(original);
        int[] test= {0,3};
        Assert.assertArrayEquals(test, result);
    }
}
