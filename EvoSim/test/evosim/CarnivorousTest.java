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
public class CarnivorousTest extends TestCase
{
    
    public CarnivorousTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(CarnivorousTest.class);
        return suite;
    }

    /**
     * Test of eat method, of class Carnivorous.
     */
    public void testEat()
    {
        System.out.println("eat");
        Creature creature = null;
        Carnivorous instance = new CarnivorousImpl();
        instance.eat(creature);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class CarnivorousImpl implements Carnivorous
    {

        public void eat(Creature creature)
        {
        }
    }
    
}
