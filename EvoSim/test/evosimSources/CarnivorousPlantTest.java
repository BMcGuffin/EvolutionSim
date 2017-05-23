/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosimSources;

import evosimSources.CarnivorousPlant;
import evosimSources.Creature;
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
        
        double size = instance.size;
        assertEquals(0,instance.age);
        assertFalse(instance.isHungry());
        instance.grow();
        double after = instance.size;
        assertFalse(size == after);
        assertEquals(1,instance.age);
        
        assertTrue(instance.isHungry());
        size = instance.size;
        instance.grow();
        after = instance.size;
        assertEquals(2,instance.age);
        assertTrue(instance.isHungry());
        assertTrue(size == after);
    }

    /**
     * Test of eat method, of class CarnivorousPlant.
     */
    public void testEat()
    {
        System.out.println("eat");
        Herbivore creature = new Herbivore();
        CarnivorousPlant instance = new CarnivorousPlant();
        assertFalse(instance.isHungry());
        instance.grow();
        assertTrue(instance.isHungry());
        instance.eat(creature);
        assertFalse(instance.isHungry());
        instance.grow();
        assertTrue(instance.isHungry());
    }

    /**
     * Test of isHungry method, of class CarnivorousPlant.
     */
    public void testIsHungry()
    {
        System.out.println("isHungry");
        CarnivorousPlant instance = new CarnivorousPlant();
        boolean result = instance.isHungry();
        assertFalse(result);
        
        instance.grow();
        assertTrue(instance.isHungry());
    }
    
}
