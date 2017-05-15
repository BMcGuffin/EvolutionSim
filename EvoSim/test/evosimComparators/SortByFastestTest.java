/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosimComparators;

import junit.framework.TestCase;

/**
 *
 * @author bryanmcguffin
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
        Object o1 = null;
        Object o2 = null;
        SortByFastest instance = new SortByFastest();
        int expResult = 0;
        int result = instance.compare(o1, o2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
