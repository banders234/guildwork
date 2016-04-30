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
public class Unlucky1Test {
    
    public Unlucky1Test() {
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
    public void Unlucky1Test1() {
        Unlucky1 u1 = new Unlucky1();
        int[] original={1,3,4,5};
        boolean result = u1.unlucky1(original);
        Assert.assertEquals(true, result);
    }
    @Test
    public void Unlucky2Test1() {
        Unlucky1 u1 = new Unlucky1();
        int[] original={2,1,3,4,5};
        boolean result = u1.unlucky1(original);
        Assert.assertEquals(true, result);
    }
    @Test
    public void Unlucky3Test1() {
        Unlucky1 u1 = new Unlucky1();
        int[] original={1,1,1};
        boolean result = u1.unlucky1(original);
        Assert.assertEquals(false, result);
    }
}
