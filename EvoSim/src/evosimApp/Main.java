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
 * The main application class for the simulation.
 *
 * @author Bryan McGuffin
 * @version 5-15-17
 */
public class Main
{

    /**Run the simulation. Get command line arguments and set global values
 based on them. Then call StandardSimLogic to execute the main program loop.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        EvoConstants.MAP= new Map(EvoConstants.MAP_SIZE);
        final MapDisplay mpd = new MapDisplay(EvoConstants.MAP);
        List<String> flags = Arrays.asList(args);
        AppLogic logic;
        if(args.length > 0 && flags.contains("-plants"))
        {
            logic = new PlantGrowthTestLogic();
        }
        else
        {
            logic = new StandardSimLogic();
        }
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
        logic.run(forever);
    }
}
