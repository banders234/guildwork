/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.flooringmastery.dao.OrderDao;
import com.mycompany.flooringmastery.dto.Order;
import java.util.List;
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
public class FlooringTest {
    
    public FlooringTest() {
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
    public void AddRemoveOrderTest() {
        OrderDao orderBook = new OrderDao();
        int count1 = orderBook.getCount();
        Order myOrder1 = new Order();
        Order myOrder2=new Order();
        orderBook.create(myOrder1);
        orderBook.create(myOrder2);
        int count2 = orderBook.getCount();
        List<Order> myOrders = orderBook.getAll();
        Assert.assertEquals(true, myOrders.contains(myOrder1));
        Assert.assertEquals(true, myOrders.contains(myOrder2));
        Assert.assertEquals(count1+2, count2);
        orderBook.delete(myOrder1);
        orderBook.delete(myOrder2);
        int count3=orderBook.getCount();
        myOrders = orderBook.getAll();
        Assert.assertEquals(false, myOrders.contains(myOrder1));
        Assert.assertEquals(false, myOrders.contains(myOrder2));
        Assert.assertEquals(count2-2, count3);
    }
}
