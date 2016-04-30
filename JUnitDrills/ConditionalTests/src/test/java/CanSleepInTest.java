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
public class CanSleepInTest {
    
    public CanSleepInTest() {
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
    public void canSleepInTest1() {
        CanSleepIn csi = new CanSleepIn();
        boolean weekday=false;
        boolean vacation=false;
        boolean result = csi.canSleepIn(weekday, vacation);
        Assert.assertEquals(true, result);
        weekday=true;
        vacation=false;
        result = csi.canSleepIn(weekday, vacation);
        Assert.assertEquals(false, result);
        weekday=false;
        vacation=true;
        result = csi.canSleepIn(weekday, vacation);
        Assert.assertEquals(true, result);
    }
    
}
