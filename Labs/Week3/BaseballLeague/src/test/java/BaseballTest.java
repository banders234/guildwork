/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.baseballleague.dao.TeamDao;
import com.mycompany.baseballleague.dao.TeamDaoImpl;
import com.mycompany.baseballleague.dto.Team;
import java.util.ArrayList;
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
public class BaseballTest {
    
    public BaseballTest() {
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
    public void BaseballTest() {
        int count1, count2;
        TeamDao dao = new TeamDaoImpl();
        Team team = new Team();
        count1 = dao.getCount();
        team.setName("Rangers");
        team.setLocation("Texas");
        Team team1 = dao.create(team);
        team = new Team();
        team.setName("Red Sox");
        team.setLocation("Boston");
        Team team2 = dao.create(team);
        count2=dao.getCount();
        List<Team> result = dao.getAll();
        Assert.assertEquals(true, result.contains(team1));
        Assert.assertEquals(true, result.contains(team2));
        Assert.assertEquals(count1+2, count2);
        dao.delete(team1);
        dao.delete(team2);
    }
}
