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
public class MissingCharTest {
    
    public MissingCharTest() {
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
    public void MissingCharTest1() {
        MissingChar mc = new MissingChar();
        String result = mc.missingChar("kitten", 1);
        Assert.assertEquals("ktten", result);
    }
    @Test
    public void MissingCharTest2() {
        MissingChar mc = new MissingChar();
        String result = mc.missingChar("kitten", 0);
        Assert.assertEquals("itten", result);
    }
    @Test
    public void MissingCharTest3() {
        MissingChar mc = new MissingChar();
        String result = mc.missingChar("kitten", 4);
        Assert.assertEquals("kittn", result);
    }
}
