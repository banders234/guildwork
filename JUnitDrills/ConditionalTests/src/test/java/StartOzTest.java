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
public class StartOzTest {
    
    public StartOzTest() {
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
    public void startOzTest1() {
        StartOz so = new StartOz();
        String result = so.startOz("ozymandias");
        Assert.assertEquals("oz", result);
    }
    @Test
    public void startOzTest2() {
        StartOz so = new StartOz();
        String result = so.startOz("bzoo");
        Assert.assertEquals("z", result);
    }
    @Test
    public void startOzTest3() {
        StartOz so = new StartOz();
        String result = so.startOz("oxx");
        Assert.assertEquals("o", result);
    }
}
