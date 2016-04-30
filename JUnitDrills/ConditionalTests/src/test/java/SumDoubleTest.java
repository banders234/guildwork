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
public class SumDoubleTest {
    
    public SumDoubleTest() {
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
    public void sumDoubleTest1() {
        SumDouble sd = new SumDouble();
        int a = 1;
        int b = 2;
        int result = sd.sumDouble(a,b);
        Assert.assertEquals(3, result);
    }
    @Test
    public void sumDoubleTest22() {
        SumDouble sd = new SumDouble();
        int a = 3;
        int b = 2;
        int result = sd.sumDouble(a,b);
        Assert.assertEquals(5, result);
    }
    @Test
    public void sumDoubleTest3() {
        SumDouble sd = new SumDouble();
        int a = 2;
        int b = 2;
        int result = sd.sumDouble(a,b);
        Assert.assertEquals(8, result);
    }
}
