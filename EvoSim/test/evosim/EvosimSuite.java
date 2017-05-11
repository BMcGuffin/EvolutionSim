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
public class EvosimSuite extends TestCase
{
    
    public EvosimSuite(String testName)
    {
        super(testName);
    }
    
    public static Test suite()
    {
        TestSuite suite = new TestSuite("EvosimSuite");
        suite.addTest(PlantTest.suite());
        suite.addTest(HerbivorousTest.suite());
        suite.addTest(MainTest.suite());
        suite.addTest(OrganismTest.suite());
        suite.addTest(CreatureTest.suite());
        suite.addTest(CarnivorousTest.suite());
        suite.addTest(EvoConstantsTest.suite());
        suite.addTest(MobileTest.suite());
        suite.addTest(SimpleBattleDeciderTest.suite());
        suite.addTest(CarnivoreTest.suite());
        suite.addTest(CarnivorousPlantTest.suite());
        suite.addTest(HerbivoreTest.suite());
        return suite;
    }
    
}
