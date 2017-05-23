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
 * @author bryanmcguffin
 */
public class SortByCreationDateTest extends TestCase
{
    
    public SortByCreationDateTest(String testName)
    {
        super(testName);
    }

    /**
     * Test of compare method, of class SortByCreationDate.
     */
    public void testCompare()
    {
        System.out.println("compare");
        Object ob1 = new Object();
        Object ob2 = new Object();
        SortByCreationDate instance = new SortByCreationDate();
        int result = instance.compare(ob1, ob2);
        assertEquals(0, result);
        
        Carnivore c1 = new Carnivore();
        Herbivore h1 = new Herbivore();
        Plant p1 = new Plant();
        CarnivorousPlant p2 = new CarnivorousPlant();
        
        Carnivore c2 = c1;
        
        result = instance.compare(c1, h1);
        assertEquals(-1, result);
        
        result = instance.compare(h1, p1);
        assertEquals(-1, result);
        
        result = instance.compare(p1, p2);
        assertEquals(-1, result);
        
        result = instance.compare(p2, c1);
        assertEquals(1, result);
        
        result = instance.compare(c1, c2);
        assertEquals(0, result);
    }
    
}
