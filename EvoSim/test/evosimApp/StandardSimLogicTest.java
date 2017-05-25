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
public class StandardSimLogicTest extends TestCase
{

    public StandardSimLogicTest(String testName)
    {
        super(testName);
    }

    /**
     * Test of run method, of class SimLogic.
     */
    public void testRun()
    {
        System.out.println("run");
        /*
         As it stands, this method should not be tested because the main loop does
        not ordinarily terminate at any time; it runs forever.
        This test file should be kept as a stub so that future methods may
        be tested if necessary.
         */
        assertEquals(1, 1);
    }

}
