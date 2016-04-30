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
public class RotateLeftTest {
    
    public RotateLeftTest() {
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
    public void RotateLeftTest1 () {
        RotateLeft rl = new RotateLeft();
        int[] original = {1, 2, 3};
        int[] result= rl.rotateLeft(original);
        int[] test = {2, 3, 1};
        Assert.assertArrayEquals(test, result);
    }
    @Test
    public void RotateLeftTest2 () {
        RotateLeft rl = new RotateLeft();
        int[] original = {5, 11, 9};
        int[] result= rl.rotateLeft(original);
        int[] test = {11, 9, 5};
        Assert.assertArrayEquals(test, result);
    }
    @Test
    public void RotateLeftTest3 () {
        RotateLeft rl = new RotateLeft();
        int[] original = {7, 0, 0};
        int[] result= rl.rotateLeft(original);
        int[] test = {0, 0, 7};
        Assert.assertArrayEquals(test, result);
    }
}
