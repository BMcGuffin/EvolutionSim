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
public class CreatureTest extends TestCase
{
    
    public CreatureTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(CreatureTest.class);
        return suite;
    }

    /**
     * Test of isMature method, of class Creature.
     */
    public void testIsMature()
    {
        System.out.println("isMature");
        Creature instance = new Creature();
        boolean expResult = false;
        boolean result = instance.isMature();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAlive method, of class Creature.
     */
    public void testIsAlive()
    {
        System.out.println("isAlive");
        Creature instance = new Creature();
        boolean expResult = false;
        boolean result = instance.isAlive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of grow method, of class Creature.
     */
    public void testGrow()
    {
        System.out.println("grow");
        Creature instance = new Creature();
        instance.grow();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reproduce method, of class Creature.
     */
    public void testReproduce()
    {
        System.out.println("reproduce");
        Organism other = null;
        Creature instance = new Creature();
        Organism expResult = null;
        Organism result = instance.reproduce(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class Creature.
     */
    public void testMove()
    {
        System.out.println("move");
        int x = 0;
        int y = 0;
        Object[][] grid = null;
        Creature instance = new Creature();
        instance.move(x, y, grid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAttack method, of class Creature.
     */
    public void testGetAttack()
    {
        System.out.println("getAttack");
        Creature instance = new Creature();
        int expResult = 0;
        int result = instance.getAttack();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDefense method, of class Creature.
     */
    public void testGetDefense()
    {
        System.out.println("getDefense");
        Creature instance = new Creature();
        int expResult = 0;
        int result = instance.getDefense();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpeed method, of class Creature.
     */
    public void testGetSpeed()
    {
        System.out.println("getSpeed");
        Creature instance = new Creature();
        int expResult = 0;
        int result = instance.getSpeed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBelly method, of class Creature.
     */
    public void testGetBelly()
    {
        System.out.println("getBelly");
        Creature instance = new Creature();
        int expResult = 0;
        int result = instance.getBelly();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLifetime method, of class Creature.
     */
    public void testGetLifetime()
    {
        System.out.println("getLifetime");
        Creature instance = new Creature();
        int expResult = 0;
        int result = instance.getLifetime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHP method, of class Creature.
     */
    public void testGetHP()
    {
        System.out.println("getHP");
        Creature instance = new Creature();
        int expResult = 0;
        int result = instance.getHP();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGrowthRate method, of class Creature.
     */
    public void testGetGrowthRate()
    {
        System.out.println("getGrowthRate");
        Creature instance = new Creature();
        double expResult = 0.0;
        double result = instance.getGrowthRate();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class Creature.
     */
    public void testGetSize()
    {
        System.out.println("getSize");
        Creature instance = new Creature();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isHungry method, of class Creature.
     */
    public void testIsHungry()
    {
        System.out.println("isHungry");
        Creature instance = new Creature();
        boolean expResult = false;
        boolean result = instance.isHungry();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of damage method, of class Creature.
     */
    public void testDamage()
    {
        System.out.println("damage");
        int amount = 0;
        Creature instance = new Creature();
        instance.damage(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
