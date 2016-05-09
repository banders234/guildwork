/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.vendingmachine.dao.VendingMachineDao;
import com.mycompany.vendingmachine.dto.Change;
import com.mycompany.vendingmachine.dto.VendingItem;
import java.text.ParseException;
import java.util.List;
import junit.framework.Assert;
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
public class VendingMachineTest {
    
    public VendingMachineTest() {
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
    public void changeTest() {
        Change change = new Change();
        change.getChange(0.41);
        Assert.assertEquals(1, change.getQuarters());
        Assert.assertEquals(1, change.getDimes());
        Assert.assertEquals(1, change.getNickels());
        Assert.assertEquals(1, change.getPennies());
    }
    @Test
    public void VendingMachineTest() throws ParseException  {
        VendingMachineDao dao = new VendingMachineDao();
        VendingItem item = new VendingItem();
        int count = dao.getCount();
        item.setName("Doritos");
        item.setCost(1.25);
        VendingItem item1 = dao.create(item);
        item = new VendingItem();
        item.setName("Candy");
        item.setCost(0.60);
        VendingItem item2 = dao.create(item);
        List<VendingItem> result = dao.getAll();
        int count2=dao.getCount();
        org.junit.Assert.assertEquals(true, result.contains(item1));
        org.junit.Assert.assertEquals(true, result.contains(item2));
        org.junit.Assert.assertEquals(count2, count+2);
        dao.delete(item1);
        dao.delete(item2);
    }
}
