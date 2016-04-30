/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.firstlast6.FirstLast6;
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
public class FirstLast6Test {
    
    public FirstLast6Test() {
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
    public void testFirstLast6one() {
        FirstLast6 fl6 = new FirstLast6();
        //If 30 cigars and it's not the weekend. bad party
        int[] numbers = {1, 2, 6};
        boolean result = fl6.FirstLast6(numbers);
        Assert.assertEquals(true, result);
    }
    @Test
    public void testFirstLast6two() {
        FirstLast6 fl6 = new FirstLast6();
        //If 30 cigars and it's not the weekend. bad party
        int[] numbers = {6, 1, 2, 3};
        boolean result = fl6.FirstLast6(numbers);
        Assert.assertEquals(true, result);
       
    }
    @Test
    public void testFirstLast6three() {
        FirstLast6 fl6 = new FirstLast6();
        //If 30 cigars and it's not the weekend. bad party
        int[] numbers = {13, 6, 1, 2, 3};
        boolean result = fl6.FirstLast6(numbers);
        Assert.assertEquals(false, result);
    }
}
