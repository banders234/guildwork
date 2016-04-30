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
public class ParrotTroubleTest {
    
    public ParrotTroubleTest() {
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
    public void ParrotTroubleTest1() {
        ParrotTrouble pt = new ParrotTrouble();
        boolean result = pt.parrotTrouble(true, 6);
        Assert.assertEquals(true, result);
    }
    @Test
    public void ParrotTroubleTest2() {
        ParrotTrouble pt = new ParrotTrouble();
        boolean result = pt.parrotTrouble(true, 7);
        Assert.assertEquals(false, result);
    }
    @Test
    public void ParrotTroubleTest3() {
        ParrotTrouble pt = new ParrotTrouble();
        boolean result = pt.parrotTrouble(false, 6);
        Assert.assertEquals(false, result);
    }
    
}
