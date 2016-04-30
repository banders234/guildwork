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
public class CloserTest {
    
    public CloserTest() {
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
    public void closerTest1() {
        Closer c = new Closer();
        int result = c.closer(8, 13);
        Assert.assertEquals(8, result);
    }
    @Test
    public void closerTest2() {
        Closer c = new Closer();
        int result = c.closer(13, 8);
        Assert.assertEquals(8, result);
    }
    @Test
    public void closerTest3() {
        Closer c = new Closer();
        int result = c.closer(13, 7);
        Assert.assertEquals(0, result);
    }
            
}
