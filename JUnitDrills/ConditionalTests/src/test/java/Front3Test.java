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
public class Front3Test {
    
    public Front3Test() {
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
    public void front3Test1() {
        Front3 f3 = new Front3();
        String result = f3.front3("Microsoft");
        Assert.assertEquals("MicMicMic", result);
    }
    @Test
    public void front3Test2() {
        Front3 f3 = new Front3();
        String result = f3.front3("Chocolate");
        Assert.assertEquals("ChoChoCho", result);
    }
    @Test
    public void front3Test3() {
        Front3 f3 = new Front3();
        String result = f3.front3("at");
        Assert.assertEquals("atatat", result);
    }
}
