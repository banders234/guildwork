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
public class NotStringTest {
    
    public NotStringTest() {
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
    public void NotStringTest1() {
        NotString ns = new NotString();
        String result = ns.notString("candy");
        Assert.assertEquals("not candy", result);
    }
    @Test
    public void NotStringTest2() {
        NotString ns = new NotString();
        String result = ns.notString("x");
        Assert.assertEquals("not x", result);
    }
    @Test
    public void NotStringTest3() {
        NotString ns = new NotString();
        String result = ns.notString("not bad");
        Assert.assertEquals("not bad", result);
    }
}
