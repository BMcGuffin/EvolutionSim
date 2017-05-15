/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosimApp;

import junit.framework.TestCase;

/**
 *
 * @author bryanmcguffin
 */
public class SimLogicTest extends TestCase
{
    
    public SimLogicTest(String testName)
    {
        super(testName);
    }

    /**
     * Test of run method, of class SimLogic.
     */
    public void testRun()
    {
        System.out.println("run");
        boolean forever = false;
        SimLogic.run(forever);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
