/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evosimApp;

import evosimSources.Map;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        EvoConstants.MAP= new Map();
        final MapDisplay mpd = new MapDisplay(EvoConstants.MAP);
        List<String> flags = Arrays.asList(args);
        boolean forever = args.length > 0 && flags.contains("-forever");
        EvoConstants.debug = args.length > 0 && flags.contains("-debug");
        
        /* Make the JFrame visible */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                mpd.setVisible(true);
            }
        });
        SimLogic.run(forever);
    }
}
