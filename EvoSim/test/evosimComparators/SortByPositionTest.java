/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosimComparators;

import evosimSources.*;
import evosimSources.Organism;
import junit.framework.TestCase;

/**
 *
 * @author bryanmcguffin
 */
public class SortByPositionTest extends TestCase
{

    public SortByPositionTest(String testName)
    {
        super(testName);
    }

    /**
     * Test of compare method, of class SortByPosition. REMEMBER: -1 if the
     * first organism has the earlier position, 1 if the second does, 0 if they
     * have the same position or they aren't both organisms
     */
    public void testCompare()
    {
        System.out.println("compare");
        Object ob1 = new Object();
        Object ob2 = new Object();
        SortByPosition instance = new SortByPosition();
        int result = instance.compare(ob1, ob2);
        assertEquals(0, result);

        Organism o1 = new Plant();
        Organism o2 = new Plant();

        o1.setPosition(0, 1);
        o2.setPosition(2, 2);

        result = instance.compare(o1, o2);
        assertEquals(-1, result);

        result = instance.compare(o2, o1);
        assertEquals(1, result);

        Organism o3 = new Plant();
        Organism o4 = new Plant();
        
        o3.setPosition(0, 1);
        o4.setPosition(1, 0);

        result = instance.compare(o3, o4);
        assertEquals(-1, result);
        
        Organism o5 = new Plant();
        Organism o6 = new Plant();
        
        o5.setPosition(4, 4);
        o6.setPosition(4, 4);
        
        result = instance.compare(o5, 06);
        assertEquals(0, result);

    }

}
