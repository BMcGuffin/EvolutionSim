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
public class CarnivoreTest extends TestCase
{
    
    public CarnivoreTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(CarnivoreTest.class);
        return suite;
    }

    /**
     * Test of reproduce method, of class Carnivore.
     */
    public void testReproduce()
    {
        System.out.println("reproduce");
        Carnivore other = null;
        Carnivore instance = new Carnivore();
        Carnivore expResult = null;
        Carnivore result = instance.reproduce(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eat method, of class Carnivore.
     */
    public void testEat()
    {
        System.out.println("eat");
        Creature creature = null;
        Carnivore instance = new Carnivore();
        instance.eat(creature);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
