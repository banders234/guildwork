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
public class GetMiddleTest {
    
    public GetMiddleTest() {
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
    public void getMiddleTest1() {
        GetMiddle gm = new GetMiddle();
        int[] array1 = {1,2,3};
        int[] array2 = {4,5,6};
        int[] result = gm.getMiddle(array1, array2);
        int[] test = {2,5};
        Assert.assertArrayEquals(test, result);
    }
    @Test
    public void getMiddleTest2() {
        GetMiddle gm = new GetMiddle();
        int[] array1 = {7,7,7};
        int[] array2 = {3,8,0};
        int[] result = gm.getMiddle(array1, array2);
        int[] test = {7,8};
        Assert.assertArrayEquals(test, result);
    }
    @Test
    public void getMiddleTest3() {
        GetMiddle gm = new GetMiddle();
        int[] array1 = {5,2,9};
        int[] array2 = {1,4,5};
        int[] result = gm.getMiddle(array1, array2);
        int[] test = {2,4};
        Assert.assertArrayEquals(test, result);
    }
}
