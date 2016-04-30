/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class FrontBackTest {
    
    public FrontBackTest() {
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
    public void frontBackTest1() {
        FrontBack fb = new FrontBack();
        String result = fb.frontBack("code");
        Assert.assertEquals("eodc", result);
    }
    @Test
    public void frontBackTest2() {
        FrontBack fb = new FrontBack();
        String result = fb.frontBack("a");
        Assert.assertEquals("a", result);
    }
    @Test
    public void frontBackTest3() {
        FrontBack fb = new FrontBack();
        String result = fb.frontBack("ab");
        Assert.assertEquals("ba", result);
    }
}
