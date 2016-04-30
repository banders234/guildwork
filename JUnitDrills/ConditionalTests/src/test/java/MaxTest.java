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
public class MaxTest {
    
    public MaxTest() {
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
    public void MaxTest1 () {
        Max m = new Max();
        int result = m.max(1,2,3);
        Assert.assertEquals(3, result);
    }
    @Test
    public void MaxTest2 () {
        Max m = new Max();
        int result = m.max(1,3,2);
        Assert.assertEquals(3, result);
    }
    @Test
    public void MaxTest3 () {
        Max m = new Max();
        int result = m.max(3,2,1);
        Assert.assertEquals(3, result);
    }
}
