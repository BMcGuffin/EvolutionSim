/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosimSources;

import evosimSources.Creature;
import evosimApp.EvoConstants;
import evosimSources.Carnivore;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Bryan McGuffin
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
        Carnivore other =     new Carnivore(10,  2, 4, 7, 6, 11, 20);
        Carnivore instance =  new Carnivore(10, 20, 4, 9, 8, 11, 10);
        Carnivore expResult = new Carnivore(10, 11, 4, 8, 7, 11, 15);
        Carnivore result = instance.reproduce(other);
        assertEquals(expResult.getHP(), result.getHP());
        assertEquals(expResult.getAttack(), result.getAttack());
        assertEquals(expResult.getDefense(), result.getDefense());
        assertEquals(expResult.getSpeed(), result.getSpeed());
        assertEquals(expResult.getGrowthRate(), result.getGrowthRate());
        assertEquals(expResult.getBelly(), result.getBelly());
        assertEquals(expResult.getLifetime(), result.getLifetime());   
    }

    /**
     * Test of eat method, of class Carnivore.
     */
    public void testEat()
    {
        System.out.println("eat");
        Herbivore creature = new Herbivore();
        Carnivore instance = new Carnivore();
        assertEquals(EvoConstants.INIT_BELLY,instance.fullness);
        instance.grow();
        instance.grow();
        instance.grow();
        assertEquals(EvoConstants.INIT_BELLY-3,instance.fullness);
        instance.eat(creature);
        assertEquals(EvoConstants.INIT_BELLY-2,instance.fullness);
    }
    
}
