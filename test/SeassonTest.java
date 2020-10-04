/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.Match;
import model.Seasson;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author giuliog
 */
public class SeassonTest {
    
    public SeassonTest() {
    }
    
    @Test(expected = RuntimeException.class)
    public void test01() {
        Seasson s = new Seasson();
        s.addMatch(null);
    }
    
    @Test
    public void test02() {
        Seasson s = new Seasson();
        
        Match m1 = new Match();
        m1.setMatchScore((short) 12);
        s.addMatch(m1);
        
        assertEquals(12, s.getMinimumScore());
        assertEquals(12, s.getMaximumScore());
        assertEquals(0, s.getMinimumScoreBrokenTimes());
        assertEquals(0, s.getMaximumScoreBrokenTimes());
    }
    
    @Test
    public void test03() {
        Seasson s = new Seasson();
        
        Match m1 = new Match();
        m1.setMatchScore((short) 12);
        s.addMatch(m1);
        
        Match m2 = new Match();
        m2.setMatchScore((short) 24);
        s.addMatch(m2);
        
        assertEquals(12, s.getMinimumScore());
        assertEquals(24, s.getMaximumScore());
        assertEquals(0, s.getMinimumScoreBrokenTimes());
        assertEquals(1, s.getMaximumScoreBrokenTimes());
    }
    
    @Test
    public void test04() {
        Seasson s = new Seasson();
        
        Match m1 = new Match();
        m1.setMatchScore((short) 12);
        s.addMatch(m1);
        
        Match m2 = new Match();
        m2.setMatchScore((short) 24);
        s.addMatch(m2);
        
        Match m3 = new Match();
        m3.setMatchScore((short) 10);
        s.addMatch(m3);
        
        assertEquals(10, s.getMinimumScore());
        assertEquals(24, s.getMaximumScore());
        assertEquals(1, s.getMinimumScoreBrokenTimes());
        assertEquals(1, s.getMaximumScoreBrokenTimes());    
    }
    
    @Test
    public void test05() {
        Seasson s = new Seasson();
        
        Match m1 = new Match();
        m1.setMatchScore((short) 12);
        s.addMatch(m1);
        
        Match m2 = new Match();
        m2.setMatchScore((short) 24);
        s.addMatch(m2);
        
        Match m3 = new Match();
        m3.setMatchScore((short) 10);
        s.addMatch(m3);
        
        Match m4 = new Match();
        m4.setMatchScore((short) 24);
        s.addMatch(m4);
        
        assertEquals(10, s.getMinimumScore());
        assertEquals(24, s.getMaximumScore());
        assertEquals(1, s.getMinimumScoreBrokenTimes());
        assertEquals(1, s.getMaximumScoreBrokenTimes());   
    }
    
}
