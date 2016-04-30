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
public class Between10and20Test {
    
    public Between10and20Test() {
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
    public void between10and20Test1() {
        Between10and20 b = new Between10and20();
        boolean result = b.between10and20(12, 99);
        Assert.assertEquals(true, result);
    }
    @Test
    public void between10and20Test2() {
        Between10and20 b = new Between10and20();
        boolean result = b.between10and20(21, 12);
        Assert.assertEquals(true, result);
    }
    @Test
    public void between10and20Test3() {
        Between10and20 b = new Between10and20();
        boolean result = b.between10and20(8, 99);
        Assert.assertEquals(false, result);
    }
}
