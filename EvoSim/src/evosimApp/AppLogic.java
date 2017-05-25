/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evosimApp;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryanmcguffin
 */
public abstract class AppLogic
{   
    /**
     * Runs the game. Sets up the board and performs turns.
     *
     * @param runForever whether or not to run the game forever, with no regard to
     * creature death events.
     */
    void run(boolean runForever)
    {
        //Reset global ID
        EvoConstants.ID = 1;
        //Set up board, add organisms
        setup();

        try
        {
            sleep(2000);
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Main loop
        while (true)
        {
            takeTurn(runForever);
            try
            {
                sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    abstract void setup();
    
    abstract void takeTurn(boolean runForever);
}
