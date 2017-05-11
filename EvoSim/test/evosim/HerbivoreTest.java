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
public class HerbivoreTest extends TestCase
{
    
    public HerbivoreTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(HerbivoreTest.class);
        return suite;
    }

    /**
     * Test of reproduce method, of class Herbivore.
     */
    public void testReproduce()
    {
        System.out.println("reproduce");
        Herbivore other = null;
        Herbivore instance = new Herbivore();
        Herbivore expResult = null;
        Herbivore result = instance.reproduce(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eat method, of class Herbivore.
     */
    public void testEat()
    {
        System.out.println("eat");
        Plant plant = null;
        Herbivore instance = new Herbivore();
        instance.eat(plant);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
