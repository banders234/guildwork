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
public class Diff21Test {
    
    public Diff21Test() {
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
    public void diff21Test1() {
        Diff21 d21 = new Diff21();
        int a=23;
        int result= d21.diff21(a);
        Assert.assertEquals(4, result);
    }
    public void diff21Test2() {
        Diff21 d21 = new Diff21();
        int a=10;
        int result= d21.diff21(a);
        Assert.assertEquals(11, result);
    }
    public void diff21Test3() {
        Diff21 d21 = new Diff21();
        int a=21;
        int result= d21.diff21(a);
        Assert.assertEquals(0, result);
    }
}
