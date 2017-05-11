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
public class PlantTest extends TestCase
{
    
    public PlantTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(PlantTest.class);
        return suite;
    }

    /**
     * Test of isMature method, of class Plant.
     */
    public void testIsMature()
    {
        System.out.println("isMature");
        Plant instance = new Plant();
        boolean expResult = false;
        boolean result = instance.isMature();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of grow method, of class Plant.
     */
    public void testGrow()
    {
        System.out.println("grow");
        Plant instance = new Plant();
        instance.grow();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of damage method, of class Plant.
     */
    public void testDamage()
    {
        System.out.println("damage");
        int amount = 0;
        Plant instance = new Plant();
        instance.damage(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAlive method, of class Plant.
     */
    public void testIsAlive()
    {
        System.out.println("isAlive");
        Plant instance = new Plant();
        boolean expResult = false;
        boolean result = instance.isAlive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reproduce method, of class Plant.
     */
    public void testReproduce()
    {
        System.out.println("reproduce");
        Organism other = null;
        Plant instance = new Plant();
        Organism expResult = null;
        Organism result = instance.reproduce(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGrowthRate method, of class Plant.
     */
    public void testGetGrowthRate()
    {
        System.out.println("getGrowthRate");
        Plant instance = new Plant();
        double expResult = 0.0;
        double result = instance.getGrowthRate();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLifetime method, of class Plant.
     */
    public void testGetLifetime()
    {
        System.out.println("getLifetime");
        Plant instance = new Plant();
        int expResult = 0;
        int result = instance.getLifetime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
