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
public class Multiple3or5Test {
    
    public Multiple3or5Test() {
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
    public void Multiple3or5Test1() {
        Multiple3or5 m35 = new Multiple3or5();
        boolean result = m35.multiple3or5(3);
        Assert.assertEquals(true, result);
    }
    @Test
    public void Multiple3or5Test2() {
        Multiple3or5 m35 = new Multiple3or5();
        boolean result = m35.multiple3or5(10);
        Assert.assertEquals(true, result);
    }
    @Test
    public void Multiple3or5Test3() {
        Multiple3or5 m35 = new Multiple3or5();
        boolean result = m35.multiple3or5(8);
        Assert.assertEquals(false, result);
    }
}
