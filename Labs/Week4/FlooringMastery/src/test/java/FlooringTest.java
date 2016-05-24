/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.flooringmastery.dao.OrderDao;
import com.mycompany.flooringmastery.dao.ProductCsvDaoImpl;
import com.mycompany.flooringmastery.dao.ProductDao;
import com.mycompany.flooringmastery.dao.TaxCsvDaoImpl;
import com.mycompany.flooringmastery.dao.TaxDao;
import com.mycompany.flooringmastery.dto.Order;
import com.mycompany.flooringmastery.dto.Product;
import com.mycompany.flooringmastery.dto.Tax;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public void addRemoveOrderTest() {
        Date date = new Date();
        OrderDao orderBook = new OrderDao();
        int count1 = orderBook.getCount();
        Order myOrder1 = new Order();
        Order myOrder2 = new Order();
        myOrder1.setDate(date);
        myOrder2.setDate(date);
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
    
    @Test
    public void addRemoveProductTest() {
        ProductDao productBook = new ProductCsvDaoImpl();
        Product myProduct = new Product();
        productBook.create(myProduct);
        List<Product> myProducts = productBook.getAll();
        Assert.assertEquals(true, myProducts.contains(myProduct));
        productBook.delete(myProduct);
        myProducts = productBook.getAll();
        Assert.assertEquals(false, myProducts.contains(myProduct));
    }
    
    @Test
    public void addRemoveTaxTest() {
        TaxDao taxBook = new TaxCsvDaoImpl();
        Tax myTax = new Tax();
        taxBook.create(myTax);
        List<Tax> myTaxes = taxBook.getAll();
        Assert.assertEquals(true, myTaxes.contains(myTax));
        taxBook.delete(myTax);
        myTaxes = taxBook.getAll();
        Assert.assertEquals(false, myTaxes.contains(myTax));
    }
    
    @Test
    public void getOrdersOnDateTest() throws ParseException {
        OrderDao orderBook = new OrderDao();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = sdf.parse("11/14/2016");
        Order myOrder1 = new Order();
        Order myOrder2 = new Order();
        myOrder1.setDate(date);
        myOrder2.setDate(date);
        orderBook.create(myOrder1);
        orderBook.create(myOrder2);
        List<Order> myOrders = new ArrayList<>();
        myOrders.add(myOrder1);
        myOrders.add(myOrder2);
        List<Order> orderList = orderBook.getOrdersOnDate(date);
        Assert.assertEquals(myOrders, orderList);
    }
    
    @Test
    public void updateOrderTest() throws ParseException {
        OrderDao orderBook = new OrderDao();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Order myOrder = orderBook.findOrderByNo(1);
        Assert.assertEquals("05/11/2016", sdf.format(myOrder.getDate()));
        myOrder.setDate(sdf.parse("05/14/2016"));
        orderBook.update(myOrder);
        myOrder = orderBook.findOrderByNo(1);
        Assert.assertEquals("05/14/2016", sdf.format(myOrder.getDate()));
    }

    @Test
    public void productAlphaNumTest() {
        ProductDao productBook = new ProductCsvDaoImpl();
        boolean result1 = productBook.isAlphaNumOrWS("Brick Paver");
        boolean result2 = productBook.isAlphaNumOrWS("Red, Brick");
        boolean result3 = productBook.isAlphaNumOrWS("Brick2");
        Assert.assertEquals(true, result1);
        Assert.assertEquals(false, result2);
        Assert.assertEquals(true, result3);
    }
    
    @Test 
    public void taxAlphaTest() {
        TaxDao taxBook = new TaxCsvDaoImpl();
        boolean result1 = taxBook.isAlpha("PA");
        boolean result2 = taxBook.isAlpha("P2");
        boolean result3 = taxBook.isAlpha("*A");
        Assert.assertEquals(true, result1);
        Assert.assertEquals(false, result2);
        Assert.assertEquals(false, result3);
    }
    
    @Test
    public void taxDaoContainsStateTest() {
        TaxDao taxBook = new TaxCsvDaoImpl();
        Tax tax = new Tax();
        tax.setState("TX");
        taxBook.create(tax);
        boolean result1 = taxBook.containsState("TX");
        boolean result2 = taxBook.containsState("QQ");
        Assert.assertEquals(true, result1);
        Assert.assertEquals(false, result2);
    }
    
    @Test
    public void productDaoContainsTypeTest() {
        ProductDao productBook = new ProductCsvDaoImpl();
        Product product = new Product();
        product.setType("Brick");
        productBook.create(product);
        boolean result1 = productBook.containsType("Brick");
        boolean result2 = productBook.containsType("Orange");
        Assert.assertEquals(true, result1);
        Assert.assertEquals(false, result2);
    }
}
