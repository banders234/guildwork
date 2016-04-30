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
public class EveryNthTest {
    
    public EveryNthTest() {
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
    public void everyNthTest1 () {
        EveryNth en = new EveryNth();
        String result = en.EveryNth("Miracle", 2);
        Assert.assertEquals("Mrce", result);
    }
    @Test
    public void everyNthTest2 () {
        EveryNth en = new EveryNth();
        String result = en.EveryNth("abcdefg", 2);
        Assert.assertEquals("aceg", result);
    }
    @Test
    public void everyNthTest3 () {
        EveryNth en = new EveryNth();
        String result = en.EveryNth("abcdefg", 3);
        Assert.assertEquals("adg", result);
    }
}
