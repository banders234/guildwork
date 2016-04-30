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
public class IcyHotTest {
    
    public IcyHotTest() {
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
    public void icyHotTest1() {
        IcyHot ih = new IcyHot();
        boolean result = ih.icyHot(120, -1);
        Assert.assertEquals(true, result);
    }
    @Test
    public void icyHotTest2() {
        IcyHot ih = new IcyHot();
        boolean result = ih.icyHot(-1, 120);
        Assert.assertEquals(true, result);
    }
    @Test
    public void icyHotTest3() {
        IcyHot ih = new IcyHot();
        boolean result = ih.icyHot(2, 120);
        Assert.assertEquals(false, result);
    }
}
