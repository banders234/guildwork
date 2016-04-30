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
public class Makes10Test {
    
    public Makes10Test() {
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
    public void Makes10Test1() {
        Makes10 m10 = new Makes10();
        boolean result = m10.makes10(9, 10);
        Assert.assertEquals(true, result);
    }
    @Test
    public void Makes10Test2() {
        Makes10 m10 = new Makes10();
        boolean result = m10.makes10(9, 9);
        Assert.assertEquals(false, result);
    }
    @Test
    public void Makes10Test3() {
        Makes10 m10 = new Makes10();
        boolean result = m10.makes10(1, 9);
        Assert.assertEquals(true, result);
    }
}
