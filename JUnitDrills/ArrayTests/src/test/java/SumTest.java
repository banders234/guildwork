/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class SumTest {
    
    public SumTest() {
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
    public void SumTest1 () {
       Sum s = new Sum();
       int[] numbers = {1, 2, 3};
       int result = s.sum(numbers);
       assertEquals(result, 6);
    }
    @Test
    public void SumTest2 () {
       Sum s = new Sum();
       int[] numbers = {7, 0, 0};
       int result = s.sum(numbers);
       assertEquals(result, 7);
    }
    @Test
    public void SumTest3 () {
       Sum s = new Sum();
       int[] numbers = {5, 11, 2};
       int result = s.sum(numbers);
       assertEquals(result, 18);
        
    }
}
