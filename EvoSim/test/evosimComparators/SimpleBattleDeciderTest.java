/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosimComparators;

import evosimSources.Creature;
import evosimComparators.SimpleBattleDecider;
import evosimSources.Creature;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author bryanmcguffin
 */
public class SimpleBattleDeciderTest extends TestCase
{
    
    public SimpleBattleDeciderTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(SimpleBattleDeciderTest.class);
        return suite;
    }

    /**
     * Test of compare method, of class SimpleBattleDecider.
     */
    public void testCompare()
    {
        System.out.println("compare");
        Object o1 = new Object();
        Object o2 = new Object();
        SimpleBattleDecider instance = new SimpleBattleDecider();
        int result = instance.compare(o1, o2);
        assertEquals(0, result);
        
        o1 = new Creature();
        o2 = new Creature();
        result = instance.compare(o1, o2);
        assertEquals(0, result);
        
        o1 = new Creature(10, 10, 10, 10, .5, 10, 10);
        o2 = new Creature(1, 1, 1, 1, .5, 1, 1);
        result = instance.compare(o1, o2);
        assertEquals(1, result);
        
        result = instance.compare(o2, o1);
        assertEquals(-1, result);
        
        result = instance.compare(o1, o1);
        assertEquals(0,result);
    }
    
}
