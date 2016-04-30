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
public class IxStartTest {
    
    public IxStartTest() {
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
    public void ixStartTest1() {
        IxStart is = new IxStart();
        boolean result = is.ixStart("mix snacks");
        Assert.assertEquals(true, result);
    }
    @Test
    public void ixStartTest2() {
        IxStart is = new IxStart();
        boolean result = is.ixStart("pix snacks");
        Assert.assertEquals(true, result);
    }
    @Test
    public void ixStartTest3() {
        IxStart is = new IxStart();
        boolean result = is.ixStart("piz snacks");
        Assert.assertEquals(false, result);
    }
}
