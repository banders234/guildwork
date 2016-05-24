/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.productinventory.dao.Inventory;
import com.mycompany.productinventory.dto.Coat;
import com.mycompany.productinventory.dto.Pants;
import com.mycompany.productinventory.dto.Product;
import com.mycompany.productinventory.dto.Shirt;
import com.mycompany.productinventory.dto.Shoes;
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
public class InventoryTest {
    
    public InventoryTest() {
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
    public void createDeleteTest() {
        Inventory inventory = new Inventory();
        Product product1 = new Pants();
        Product product2 = new Shirt();
        Product product3 = new Coat();
        Product product4 = new Shoes();
        inventory.create(product1);
        inventory.create(product2);
        inventory.create(product3);
        inventory.create(product4);
        List<Product> productList = inventory.all();
        Assert.assertEquals(true, productList.contains(product1));
        Assert.assertEquals(true, productList.contains(product2));
        Assert.assertEquals(true, productList.contains(product3));
        Assert.assertEquals(true, productList.contains(product4));
        inventory.delete(product1);
        inventory.delete(product2);
        inventory.delete(product3);
        inventory.delete(product4);
        productList = inventory.all();
        Assert.assertEquals(false, productList.contains(product1));
        Assert.assertEquals(false, productList.contains(product2));
        Assert.assertEquals(false, productList.contains(product3));
        Assert.assertEquals(false, productList.contains(product4));
    }
    
    @Test
    public void totalValueTest() {
        Inventory inventory = new Inventory();
        inventory.setTest();
        Product product1 = new Pants();
        product1.setPrice(40.00);
        product1.setStock(100);
        Product product2 = new Shirt();
        product2.setPrice(50.00);
        product2.setStock(50);
        Product product3 = new Coat();
        product3.setPrice(60.00);
        product3.setStock(40);
        Product product4 = new Shoes();
        product4.setPrice(70.00);
        product4.setStock(50);
        inventory.create(product1);
        inventory.create(product2);
        inventory.create(product3);
        inventory.create(product4);
        Assert.assertEquals(12400, inventory.totalValue(), 0.01);
    }
}
