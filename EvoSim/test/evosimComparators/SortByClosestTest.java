/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosimComparators;

import evosimSources.Carnivore;
import java.awt.Point;
import junit.framework.TestCase;

/**
 *
 * @author bryanmcguffin
 */
public class SortByClosestTest extends TestCase
{

    public SortByClosestTest(String testName)
    {
        super(testName);
    }

    /**
     * Test of compare method, of class SortByClosest.
     */
    public void testCompare()
    {
        System.out.println("compare");
        Object o1 = new Object();
        Object o2 = new Object();

        Point referencePoint = new Point(5, 5);
        SortByClosest instance = new SortByClosest(referencePoint);

        int result = instance.compare(o1, o2);
        assertEquals(0, result);

        Carnivore c1 = new Carnivore();
        Carnivore c2 = new Carnivore();

        result = instance.compare(c1, c2);
        assertEquals(0, result);

        c1.setPosition(1, 1);
        c2.setPosition(9, 9);

        result = instance.compare(c1, c2);
        assertEquals(0, result);

        c2.setPosition(9, 8);

        result = instance.compare(c1, c2);
        assertEquals(1, result);
        
        c1.setPosition(3, 4);
        
        result = instance.compare(c1, c2);
        assertEquals(-1, result);
        
        result = instance.compare(c2, c1);
        assertEquals(1, result);
        
        
        c2.setPosition(3, 4);
        
        result = instance.compare(c1, c2);
        assertEquals(0, result);
    }
}
