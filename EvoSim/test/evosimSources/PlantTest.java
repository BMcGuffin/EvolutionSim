/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosimSources;

import evosimApp.EvoConstants;
import evosimSources.Plant;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Bryan McGuffin
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
        boolean result = instance.isMature();
        assertFalse(result);
        for(int i = 0;instance.size < 2; i++)
        {
            instance.grow();
        }
        result = instance.isMature();
        assertTrue(result);
    }

    /**
     * Test of grow method, of class Plant.
     */
    public void testGrow()
    {
        System.out.println("grow");
        Plant instance = new Plant();
        assertEquals(1.0,instance.getSize());
        assertEquals(0,instance.age);
        instance.grow();
        assertEquals(1+1*EvoConstants.INIT_GROWTH_RATE,instance.getSize());
        assertEquals(1,instance.age);
        
        //This just tests the growth curve
        /*
        for (int i = 0; instance.getSize() < EvoConstants.CAP_PLANT_SIZE; i++)
        {
            instance.grow();
            System.out.println("Age: " + instance.age + "\tSize: "
                    + instance.size);

        }
        */
    }

    /**
     * Test of damage method, of class Plant.
     */
    public void testDamage()
    {
        System.out.println("damage");
        double amount = 0;
        Plant instance = new Plant();
        double start = instance.size;
        instance.damage((int)amount);
        double end = instance.size;
        assertTrue(start - end == amount);
        
        start = instance.size;
        amount = start + 5;
        instance.damage((int)amount);
        end = instance.size;
        assertEquals(0.0,end);
    }

    /**
     * Test of isAlive method, of class Plant.
     */
    public void testIsAlive()
    {
        System.out.println("isAlive");
        Plant instance = new Plant();
        boolean result = instance.isAlive();
        assertTrue(result);
        
        for(int i = 0;i<EvoConstants.INIT_LIFESPAN * 5;i++)
        {
            instance.grow();
            assertTrue(instance.isAlive());
        }
        assertTrue(instance.isAlive());
        instance.grow();
        assertFalse(instance.isAlive());

    }

    /**
     * Test of reproduce method, of class Plant.
     */
    public void testReproduce()
    {
        System.out.println("reproduce");
        Plant other =     new Plant(15, 0.5);
        Plant instance =  new Plant(15, 0.7);
        Plant expResult = new Plant(15, 0.6);
        Plant result = instance.reproduce(other);
        assertEquals(expResult.size, result.size);
        assertEquals(expResult.lifetime, result.lifetime);
        assertEquals(expResult.growthRate, result.growthRate);
    }

    /**
     * Test of getGrowthRate method, of class Plant.
     */
    public void testGetGrowthRate()
    {
        System.out.println("getGrowthRate");
        Plant instance = new Plant();
        double expResult = EvoConstants.INIT_GROWTH_RATE;
        double result = instance.getGrowthRate();
        assertEquals(expResult, result);
        
        Plant next = new Plant(10, 4.5);
        expResult = 4.5;
        result = next.getGrowthRate();
        assertEquals(expResult,result);
    }

    /**
     * Test of getLifetime method, of class Plant.
     */
    public void testGetLifetime()
    {
        System.out.println("getLifetime");
        Plant instance = new Plant();
        int expResult = EvoConstants.INIT_LIFESPAN * 5;
        int result = instance.getLifetime();
        assertEquals(expResult, result);
        
        Plant next = new Plant(10, 4.5);
        expResult = 10;
        result = next.getLifetime();
        assertEquals(expResult,result);
    }
    
    /**
     * Test of getLifetime method, of class Plant.
     */
    public void testGetSize()
    {
        System.out.println("getSize");
        Plant instance = new Plant();
        double expResult = EvoConstants.INIT_SIZE;
        double result = instance.getSize();
        assertEquals(expResult, result);
        
        Plant next = new Plant(10, 4.5);
        expResult = EvoConstants.INIT_SIZE;
        result = next.getSize();
        assertEquals(expResult,result);
    }
}
