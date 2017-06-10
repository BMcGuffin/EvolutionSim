/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosimApp;

import java.io.FileInputStream;
import java.util.Properties;
import junit.framework.TestCase;

/**
 *
 * @author Bryan McGuffin
 */
public class EvoConstantsTest extends TestCase
{

    public EvoConstantsTest(String testName)
    {
        super(testName);
    }

    /**
     * Test of loadConstants method, of class EvoConstants.
     */
    public void testLoadConstants()
    {
        System.out.println("loadConstants");
        Properties p = new Properties();
        try
        {
            p.load(new FileInputStream("evo.properties"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            fail("File not found");
        }
        EvoConstants.loadConstants(p);
        assertEquals(p.getProperty("turn_delay_in_ms"), ("" + EvoConstants.TURN_DELAY));
    }

}
