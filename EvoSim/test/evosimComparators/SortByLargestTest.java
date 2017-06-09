/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosimComparators;

import evosimSources.Plant;
import junit.framework.TestCase;

/**
 *
 * @author Bryan McGuffin
 */
public class SortByLargestTest extends TestCase
{
    
    public SortByLargestTest(String testName)
    {
        super(testName);
    }

    /**
     * Test of compare method, of class SortByLargest.
     */
    public void testCompare()
    {
        System.out.println("compare");
        Object o1 = new Object();
        Object o2 = new Object();
        SortByLargest instance = new SortByLargest();
        int result = instance.compare(o1, o2);
        assertEquals(0, result);
        
        Plant p1 = new Plant();
        Plant p2 = new Plant();
        
        p1.grow();
        p2.grow();
        
        assertEquals(p1.getSize(), p2.getSize());
        
        result = instance.compare(p1, p2);
        assertEquals(0, result);
        
        p1 = new Plant(10, 0.5);
        p2 = new Plant(10, 0.05);
        
        p1.grow();
        p2.grow();
        
        assertTrue(p1.getSize() > p2.getSize());
        result = instance.compare(p1, p2);
        assertEquals(-1, result);
        
        p1 = new Plant(10, 0.1);
        p2 = new Plant(10, 0.2);
        
        p1.grow();
        p2.grow();
        
        assertTrue(p1.getSize() < p2.getSize());
        result = instance.compare(p1, p2);
        assertEquals(1, result);
        
        result = instance.compare(p2, p1);
        assertEquals(-1, result);
        
        result = instance.compare(p1, p1);
        assertEquals(0, result);

    }
    
}
