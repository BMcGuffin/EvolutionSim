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
public class CarnivorousPlantTest extends TestCase
{
    
    public CarnivorousPlantTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(CarnivorousPlantTest.class);
        return suite;
    }

    /**
     * Test of grow method, of class CarnivorousPlant.
     */
    public void testGrow()
    {
        System.out.println("grow");
        CarnivorousPlant instance = new CarnivorousPlant();
        instance.grow();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eat method, of class CarnivorousPlant.
     */
    public void testEat()
    {
        System.out.println("eat");
        Creature creature = null;
        CarnivorousPlant instance = new CarnivorousPlant();
        instance.eat(creature);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isHungry method, of class CarnivorousPlant.
     */
    public void testIsHungry()
    {
        System.out.println("isHungry");
        CarnivorousPlant instance = new CarnivorousPlant();
        boolean expResult = false;
        boolean result = instance.isHungry();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
