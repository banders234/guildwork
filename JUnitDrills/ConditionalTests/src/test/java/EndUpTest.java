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
public class EndUpTest {
    
    public EndUpTest() {
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
    public void EndUpTest1() {
        EndUp eu = new EndUp();
        String result = eu.endUp("Hello");
        Assert.assertEquals("HeLLO", result);
    }
    @Test
    public void EndUpTest2() {
        EndUp eu = new EndUp();
        String result = eu.endUp("hi there");
        Assert.assertEquals("hi thERE", result);
    }
    @Test
    public void EndUpTest3() {
        EndUp eu = new EndUp();
        String result = eu.endUp("hi");
        Assert.assertEquals("HI", result);
    }
}
