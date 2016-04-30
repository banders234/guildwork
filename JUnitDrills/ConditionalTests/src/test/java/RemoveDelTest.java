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
public class RemoveDelTest {
    
    public RemoveDelTest() {
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
    public void RemoveDelTest1() {
        RemoveDel rd = new RemoveDel();
        String result = rd.removeDel("adelbc");
        Assert.assertEquals("abc", result);
    }
    @Test
    public void RemoveDelTest2() {
        RemoveDel rd = new RemoveDel();
        String result = rd.removeDel("adelHello");
        Assert.assertEquals("aHello", result);
    }
    @Test
    public void RemoveDelTest3() {
        RemoveDel rd = new RemoveDel();
        String result = rd.removeDel("adedbc");
        Assert.assertEquals("adedbc", result);
    }
}
