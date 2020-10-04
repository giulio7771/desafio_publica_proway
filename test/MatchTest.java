/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.Match;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author giuliog
 */
public class MatchTest {
    
    public MatchTest() {
    }
    
    @Test(expected = RuntimeException.class)
    public void test01() {
        Match match = new Match();
        match.setMatchScore((short) -1);
    }
    
    @Test
    public void test02() {
        Match match = new Match();
        match.setMatchScore((short) 1);
        assertEquals((short) 1, match.getMatchScore());
    }
}
