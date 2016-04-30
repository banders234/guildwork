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
public class CommonEndTest {
    
    public CommonEndTest() {
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
    public void commonEndTest1() {
        CommonEnd ce = new CommonEnd();
        int[] a = {1,2,3};
        int[] b = {7,3};
        boolean result = ce.commonEnd(a, b);
        Assert.assertEquals(true, result);
    }
    public void commonEndTest2() {
        CommonEnd ce = new CommonEnd();
        int[] a = {1,2,3};
        int[] b = {7,3,2};
        boolean result = ce.commonEnd(a, b);
        Assert.assertEquals(false, result);
    }
    public void commonEndTest3() {
        CommonEnd ce = new CommonEnd();
        int[] a = {1,2,3};
        int[] b = {1,3};
        boolean result = ce.commonEnd(a, b);
        Assert.assertEquals(true, result);
        
    }

}
