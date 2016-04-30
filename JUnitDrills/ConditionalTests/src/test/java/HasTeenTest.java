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
public class HasTeenTest {
    
    public HasTeenTest() {
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
    public void hasTeenTest1() {
        HasTeen ht = new HasTeen();
        boolean result = ht.hasTeen(13, 20, 10);
        Assert.assertEquals(true, result);
    }
    @Test
    public void hasTeenTest2() {
        HasTeen ht = new HasTeen();
        boolean result = ht.hasTeen(20, 19, 18);
        Assert.assertEquals(true, result);
    }
    @Test
    public void hasTeenTest3() {
        HasTeen ht = new HasTeen();
        boolean result = ht.hasTeen(20, 10, 12);
        Assert.assertEquals(false, result);
    }
    
}
