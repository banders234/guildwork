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
public class NearHundredTest {
    
    public NearHundredTest() {
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
    public void NearHundredTest1() {
        NearHundred nh = new NearHundred();
        boolean result = nh.nearHundred(103);
        Assert.assertEquals(true, result);
    }
    @Test
    public void NearHundredTest2() {
        NearHundred nh = new NearHundred();
        boolean result = nh.nearHundred(90);
        Assert.assertEquals(true, result);
    }
    @Test
    public void NearHundredTest3() {
        NearHundred nh = new NearHundred();
        boolean result = nh.nearHundred(89);
        Assert.assertEquals(false, result);
    }
}
