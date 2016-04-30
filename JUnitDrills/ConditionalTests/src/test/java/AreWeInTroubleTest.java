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
public class AreWeInTroubleTest {
    
    public AreWeInTroubleTest() {
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
    public void AreWeInTroubleTest1() {
        AreWeInTrouble awit = new AreWeInTrouble();
        boolean a = true;
        boolean b = true;
        boolean result= awit.areWeInTrouble(a,b);
        Assert.assertEquals(true, result);
    }
    @Test
    public void AreWeInTroubleTest2() {
        AreWeInTrouble awit = new AreWeInTrouble();
        boolean a = false;
        boolean b = false;
        boolean result= awit.areWeInTrouble(a,b);
        Assert.assertEquals(true, result);
    }
    @Test
    public void AreWeInTroubleTest3() {
        AreWeInTrouble awit = new AreWeInTrouble();
        boolean a = true;
        boolean b = false;
        boolean result= awit.areWeInTrouble(a,b);
        Assert.assertEquals(false, result);
    }
}
