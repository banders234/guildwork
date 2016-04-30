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
public class Double23Test {
    
    public Double23Test() {
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
    public void Double23Test1() {
        Double23 d23 = new Double23();
        int[] original = {2,2,3};
        boolean result = d23.double23(original);
        Assert.assertEquals(true, result);
    }
    @Test
    public void Double23Test2() {
        Double23 d23 = new Double23();
        int[] original = {2,2,3};
        boolean result = d23.double23(original);
        Assert.assertEquals(true, result);
    }
    @Test
    public void Double23Test3() {
        Double23 d23 = new Double23();
        int[] original = {2,2,3};
        boolean result = d23.double23(original);
        Assert.assertEquals(true, result);
    }
}
