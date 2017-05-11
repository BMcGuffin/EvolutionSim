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
public class HerbivorousTest extends TestCase
{
    
    public HerbivorousTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(HerbivorousTest.class);
        return suite;
    }

    /**
     * Test of eat method, of class Herbivorous.
     */
    public void testEat()
    {
        System.out.println("eat");
        Plant plant = null;
        Herbivorous instance = new HerbivorousImpl();
        instance.eat(plant);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class HerbivorousImpl implements Herbivorous
    {

        public void eat(Plant plant)
        {
        }
    }
    
}
