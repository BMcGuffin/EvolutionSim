/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosimComparators;

import evosimSources.*;
import junit.framework.TestCase;

/**
 *
 * @author Bryan McGuffin
 */
public class SortByFastestTest extends TestCase
{

    public SortByFastestTest(String testName)
    {
        super(testName);
    }

    /**
     * Test of compare method, of class SortByFastest.
     */
    public void testCompare()
    {
        System.out.println("compare");
        Object o1 = new Object();
        Object o2 = new Object();
        SortByFastest instance = new SortByFastest();
        int result = instance.compare(o1, o2);
        assertEquals(0, result);

        Plant p1 = new Plant();
        Plant p2 = new Plant();

        Carnivore c0 = new Carnivore();

        result = instance.compare(p1, p2);
        assertEquals(0, result);

        result = instance.compare(c0, p1);
        assertEquals(-1, result);

        result = instance.compare(p1, c0);
        assertEquals(1, result);

        result = instance.compare(c0, c0);
        assertEquals(0, result);

        Carnivore slowCarn = new Carnivore(1, 1, 1, 1, 1, 1, 1);
        Carnivore fastCarn = new Carnivore(5, 5, 5, 5, 5, 5, 5);

        result = instance.compare(slowCarn, fastCarn);
        assertEquals(1, result);

        result = instance.compare(fastCarn, fastCarn);
        assertEquals(0, result);

        result = instance.compare(fastCarn, slowCarn);
        assertEquals(-1, result);

    }

}
