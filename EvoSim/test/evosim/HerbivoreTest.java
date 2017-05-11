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
        Herbivore other =     new Herbivore(10,  2, 4, 7, 6, 11, 20);
        Herbivore instance =  new Herbivore(10, 20, 4, 9, 8, 11, 10);
        Herbivore expResult = new Herbivore(10, 11, 4, 8, 7, 11, 15);
        Herbivore result = instance.reproduce(other);
        assertEquals(expResult.getHP(), result.getHP());
        assertEquals(expResult.getAttack(), result.getAttack());
        assertEquals(expResult.getDefense(), result.getDefense());
        assertEquals(expResult.getSpeed(), result.getSpeed());
        assertEquals(expResult.getGrowthRate(), result.getGrowthRate());
        assertEquals(expResult.getBelly(), result.getBelly());
        assertEquals(expResult.getLifetime(), result.getLifetime()); 
    }

    /**
     * Test of eat method, of class Herbivore.
     */
    public void testEat()
    {
        System.out.println("eat");
        Plant plant = new Plant();
        Herbivore instance = new Herbivore();
        assertFalse(instance.isHungry());
        instance.grow();
        assertTrue(instance.isHungry());
        assertTrue(plant.isAlive());
        instance.eat(plant);
        assertFalse(instance.isHungry());
        assertFalse(plant.isAlive());
        
        Plant plant2 = new Plant(10, .45);
        plant2.grow();
        plant2.grow();
        plant2.grow();
        plant2.grow();
        plant2.grow();
        System.out.println("Size = "+plant2.size);
        instance.grow();
        assertTrue(instance.isAlive());
        assertTrue(instance.isHungry());
        assertTrue(plant2.isAlive());
        instance.eat(plant2);
        assertFalse(instance.isHungry());
        assertTrue(plant2.isAlive());
        System.out.println("Size = "+plant2.size);
        instance.grow();
        instance.grow();
        instance.grow();
        assertTrue(instance.isAlive());
        assertTrue(instance.isHungry());
        assertTrue(plant2.isAlive());
        System.out.println("Size = "+plant2.size);
        instance.eat(plant2);
        System.out.println("Size = "+plant2.size);
    }    
}
