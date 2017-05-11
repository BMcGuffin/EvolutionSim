/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosim;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author bryanmcguffin
 */
public class MobileTest extends TestCase
{
    
    public MobileTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(MobileTest.class);
        return suite;
    }

    /**
     * Test of move method, of class Mobile.
     */
    public void testMove()
    {
        System.out.println("move");
        int x = 0;
        int y = 0;
        Object[][] grid = null;
        Mobile instance = new MobileImpl();
        instance.move(x, y, grid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class MobileImpl implements Mobile
    {

        public void move(int x, int y, Object[][] grid)
        {
        }
    }
    
}
