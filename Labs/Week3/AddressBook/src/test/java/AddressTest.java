/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.addressbook.dao.AddressDao;
import com.mycompany.addressbook.dao.AddressDaoImpl;
import com.mycompany.addressbook.dto.Address;
import java.text.ParseException;
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
public class AddressTest {
    
    public AddressTest() {
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
    public void AddressTest() throws ParseException  {
        AddressDao dao = new AddressDaoImpl();
        Address address = new Address();
        int count = dao.getCount();
        address.setFirstName("Brandon");
        address.setLastName("Anderson");
        Address address1 = dao.create(address);
        address = new Address();
        address.setFirstName("Tom");
        address.setLastName("Haverford");
        Address address2 = dao.create(address);
        List<Address> result = dao.getAll();
        int count2=dao.getCount();
        Assert.assertEquals(true, result.contains(address1));
        Assert.assertEquals(true, result.contains(address2));
        Assert.assertEquals(count2, count+2);
        dao.delete(address1);
        dao.delete(address2);
    }
}
