/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosimComparators;

import evosimSources.Creature;
import evosimComparators.SimpleBattleDecider;
import evosimSources.Carnivore;
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
     * REMEMBER: -1 if the first creature wins, 1 if the second creature wins, 0
     * if there is a tie OR both passed objects are not creatures
     */
    public void testCompare()
    {
        System.out.println("compare");
        Object o1 = new Object();
        Object o2 = new Object();
        SimpleBattleDecider instance = new SimpleBattleDecider();
        int result = instance.compare(o1, o2);
        assertEquals(0, result);
        
        o1 = new CreatureImpl();
        o2 = new CreatureImpl();
        result = instance.compare(o1, o2);
        assertEquals(0, result);
        
        o1 = new CreatureImpl(10, 10, 10, 10, .5, 10, 10);
        o2 = new CreatureImpl(1, 1, 1, 1, .5, 1, 1);
        result = instance.compare(o1, o2);
        assertEquals(-1, result);
        
        result = instance.compare(o2, o1);
        assertEquals(1, result);
        
        result = instance.compare(o1, o1);
        assertEquals(0,result);
    }
    
    /**
     * This is just a wrapper for the creature abstract class, to make sure
     * its methods function properly
     * 
     */
    public class CreatureImpl extends Creature
    {
        public CreatureImpl(int hp, int at, int de, int sp, double size, int belly, int lifetime)
        {
            super(hp, at, de, sp, size, belly, lifetime);
            
        }
        
        public CreatureImpl()
        {
            super();
            
        }
    };
    
}
