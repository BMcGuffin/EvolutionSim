/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosim;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryanmcguffin
 * @version 5-10-17
 */
public class Main
{

    /**Run the simulation.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Map map = new Map();
        final MapDisplay mpd = new MapDisplay(map);

        /* Make the JFrame visible */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                mpd.setVisible(true);
            }
        });
        SimLogic.run(map);
    }
}
