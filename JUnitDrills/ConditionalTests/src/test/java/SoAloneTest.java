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
public class SoAloneTest {
    
    public SoAloneTest() {
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
    public void soAloneTest1 () {
        SoAlone sa = new SoAlone();
        boolean result = sa.soAlone(13, 99);
        Assert.assertEquals(true, result);
    }
    @Test
    public void soAloneTest2 () {
        SoAlone sa = new SoAlone();
        boolean result = sa.soAlone(21, 19);
        Assert.assertEquals(true, result);
    }
    @Test
    public void soAloneTest3 () {
        SoAlone sa = new SoAlone();
        boolean result = sa.soAlone(13, 13);
        Assert.assertEquals(false, result);
    }
}
