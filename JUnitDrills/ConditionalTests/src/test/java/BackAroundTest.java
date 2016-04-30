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
public class BackAroundTest {
    
    public BackAroundTest() {
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
    public void backAroundTest1() {
        BackAround ba = new BackAround();
        String result = ba.backAround("cat");
        Assert.assertEquals("tcatt", result);
    }
    @Test
    public void backAroundTest2() {
        BackAround ba = new BackAround();
        String result = ba.backAround("Hello");
        Assert.assertEquals("oHelloo", result);
    }
    @Test
    public void backAroundTest3() {
        BackAround ba = new BackAround();
        String result = ba.backAround("a");
        Assert.assertEquals("aaa", result);
    }
}
