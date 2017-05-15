/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosimApp;

import java.util.Observable;
import junit.framework.TestCase;

/**
 *
 * @author bryanmcguffin
 */
public class MapDisplayTest extends TestCase
{
    
    public MapDisplayTest(String testName)
    {
        super(testName);
    }

    /**
     * Test of update method, of class MapDisplay.
     */
    public void testUpdate()
    {
        System.out.println("update");
        Observable o = null;
        Object arg = null;
        MapDisplay instance = null;
        instance.update(o, arg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class MapDisplay.
     */
    public void testToString()
    {
        System.out.println("toString");
        int x = 0;
        int y = 0;
        MapDisplay instance = null;
        String expResult = "";
        String result = instance.toString(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
