/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.dvdlibrary.controllers.ConsoleIO;
import com.mycompany.dvdlibrary.dao.DVDDao;
import com.mycompany.dvdlibrary.dto.DVD;
import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
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
public class DVDTest {
    
    public DVDTest() {
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
    public void DvdTest() throws ParseException  {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        DVDDao dao = new DVDDao();
        DVD dvd = new DVD();
        int count = dao.getCount();
        dvd.setTitle("Godzilla");
        Date date = sdf.parse("12/31/1970");
        dvd.setReleaseDate(date);
        DVD dvd1 = dao.create(dvd);
        dvd = new DVD();
        dvd.setTitle("Apocalypse Now");
        date = sdf.parse("02/03/1989");
        dvd.setReleaseDate(date);
        DVD dvd2 = dao.create(dvd);
        List<DVD> result = dao.getAll();
        int count2=dao.getCount();
        Assert.assertEquals(true, result.contains(dvd1));
        Assert.assertEquals(true, result.contains(dvd2));
        Assert.assertEquals(count2, count+2);
        dao.delete(dvd1);
        dao.delete(dvd2);
    }
}
