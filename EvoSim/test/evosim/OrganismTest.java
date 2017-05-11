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
public class OrganismTest extends TestCase
{
    
    public OrganismTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(OrganismTest.class);
        return suite;
    }

    /**
     * Test of isMature method, of class Organism.
     */
    public void testIsMature()
    {
        System.out.println("isMature");
        Organism instance = new OrganismImpl();
        boolean expResult = false;
        boolean result = instance.isMature();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAlive method, of class Organism.
     */
    public void testIsAlive()
    {
        System.out.println("isAlive");
        Organism instance = new OrganismImpl();
        boolean expResult = false;
        boolean result = instance.isAlive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reproduce method, of class Organism.
     */
    public void testReproduce()
    {
        System.out.println("reproduce");
        Organism other = null;
        Organism instance = new OrganismImpl();
        Organism expResult = null;
        Organism result = instance.reproduce(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of grow method, of class Organism.
     */
    public void testGrow()
    {
        System.out.println("grow");
        Organism instance = new OrganismImpl();
        instance.grow();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of damage method, of class Organism.
     */
    public void testDamage()
    {
        System.out.println("damage");
        int amount = 0;
        Organism instance = new OrganismImpl();
        instance.damage(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class OrganismImpl implements Organism
    {

        public boolean isMature()
        {
            return false;
        }

        public boolean isAlive()
        {
            return false;
        }

        public Organism reproduce(Organism other)
        {
            return null;
        }

        public void grow()
        {
        }

        public void damage(int amount)
        {
        }
    }
    
}
