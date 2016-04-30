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
public class StartHiTest {
    
    public StartHiTest() {
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
    public void startHiTest1() {
        StartHi sh = new StartHi();
        boolean result = sh.startHi("hi there");
        Assert.assertEquals(true, result);
    }
    @Test
    public void startHiTest2() {
        StartHi sh = new StartHi();
        boolean result = sh.startHi("hi");
        Assert.assertEquals(true, result);
    }
    @Test
    public void startHiTest3() {
        StartHi sh = new StartHi();
        boolean result = sh.startHi("high there");
        Assert.assertEquals(false, result);
    }
}
