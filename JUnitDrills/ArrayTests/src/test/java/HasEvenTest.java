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
public class HasEvenTest {
    
    public HasEvenTest() {
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
    public void HasEvenTest1() {
        HasEven he = new HasEven();
        int[] original ={2,5};
        boolean result = he.hasEven(original);
        Assert.assertEquals(true ,result);
    }
    public void HasEvenTest2() {
        HasEven he = new HasEven();
        int[] original ={4,3};
        boolean result = he.hasEven(original);
        Assert.assertEquals(true ,result);
    }
    public void HasEvenTest3() {
        HasEven he = new HasEven();
        int[] original ={7,5};
        boolean result = he.hasEven(original);
        Assert.assertEquals(false ,result);
    }
}
