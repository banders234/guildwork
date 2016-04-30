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
public class PosNegTest {
    
    public PosNegTest() {
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
    public void PosNegTest1() {
        PosNeg pn = new PosNeg();
        boolean result = pn.posNeg(1, -1, false);
        Assert.assertEquals(true, result);
    }
    @Test
    public void PosNegTest2() {
        PosNeg pn = new PosNeg();
        boolean result = pn.posNeg(-1, 1, false);
        Assert.assertEquals(true, result);
    }
    @Test
    public void PosNegTest3() {
        PosNeg pn = new PosNeg();
        boolean result = pn.posNeg(-4, -5, true);
        Assert.assertEquals(true, result);
    }
}
