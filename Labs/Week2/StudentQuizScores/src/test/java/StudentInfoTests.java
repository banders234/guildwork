/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.studentquizscores.StudentAverages;
import java.util.ArrayList;
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
public class StudentInfoTests {
    
    public StudentInfoTests() {
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
    public void StudentAverageTest() {
        StudentAverages sa = new StudentAverages();
        
        ArrayList<Double> average = new ArrayList<>();
        average.add(99.0);
        average.add(90.0);
        average.add(80.0);
        average.add(75.0);
        Double result = sa.getGradeAverage(average);
        Assert.assertEquals(86.0, result, 0.001);
        
    }
}
