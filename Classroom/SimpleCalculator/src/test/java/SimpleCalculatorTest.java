/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.simplecalculator.SimpleCalculator;
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
public class SimpleCalculatorTest {
    
    public SimpleCalculatorTest() {
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
    public void SimpleCalculatorAddTest1() {
        SimpleCalculator calc = new SimpleCalculator();
        double result = calc.add(87, 14);
        Assert.assertEquals(101.0, result, 0.001);
    }
    @Test
    public void SimpleCalculatorAddTest2() {
        SimpleCalculator calc = new SimpleCalculator();
        double result = calc.add(-5, -7);
        Assert.assertEquals(-12.0, result, 0.001);
    }
    @Test
    public void SimpleCalculatorAddTest3() {
        SimpleCalculator calc = new SimpleCalculator();
        double result = calc.add(7, 12);
        Assert.assertEquals(19.0, result, 0.001);
    }
    @Test
    public void SimpleCalculatorSubTest1() {
        SimpleCalculator calc = new SimpleCalculator();
        double result = calc.subtract(87, 14);
        Assert.assertEquals(73.0, result, 0.001);
    }
    @Test
    public void SimpleCalculatorSubTest2() {
        SimpleCalculator calc = new SimpleCalculator();
        double result = calc.subtract(-5, -7);
        Assert.assertEquals(2.0, result, 0.001);
    }
    
    @Test
    public void SimpleCalculatorSubTest3() {
        SimpleCalculator calc = new SimpleCalculator();
        double result = calc.subtract(7, 12);
        Assert.assertEquals(-5, result, 0.001);
    }
    @Test
    public void SimpleCalculatorMultTest1() {
        SimpleCalculator calc = new SimpleCalculator();
        double result = calc.multiply(7, 12);
        Assert.assertEquals(84.0, result, 0.001);
    }
    @Test
    public void SimpleCalculatorMultTest2() {
        SimpleCalculator calc = new SimpleCalculator();
        double result = calc.multiply(87, 14);
        Assert.assertEquals(1218.0, result, 0.001);
    }
    @Test
    public void SimpleCalculatorMultTest3() {
        SimpleCalculator calc = new SimpleCalculator();
        double result = calc.multiply(-5, -7);
        Assert.assertEquals(35.0, result, 0.001);
    }
    @Test
    public void SimpleCalculatorDivTest1() {
        SimpleCalculator calc = new SimpleCalculator();
        double result = calc.divide(7, 12);
        Assert.assertEquals(0.5833, result, 0.001);
    }
    @Test
    public void SimpleCalculatorDivTest2() {
        SimpleCalculator calc = new SimpleCalculator();
        double result = calc.divide(87, 14);
        Assert.assertEquals(6.2143, result, 0.001);
    }
    @Test
    public void SimpleCalculatorDivTest3() {
        SimpleCalculator calc = new SimpleCalculator();
        double result = calc.divide(-5, -7);
        Assert.assertEquals(0.7143, result, 0.001);
    }
}
